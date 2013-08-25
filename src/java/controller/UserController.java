/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import model.dao.UsersDAO;
import model.dao.UsersDaoImpl;
import model.entities.Users;
import model.entities.Login;
import model.entities.Roles;
import org.apache.struts2.interceptor.SessionAware;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author christian
 */
public class UserController implements SessionAware {

    Users user = new Users();
    Login login = new Login();
    Roles role = new Roles();
    UsersDAO userDAO;
    String msg;
    String activationId;
    private Map<String, Object> session;

    public UserController() {
        userDAO = new UsersDaoImpl();
    }

    //Start getters and setters
    public String getActivationId() {
        return activationId;
    }

    public void setActivationId(String activationId) {
        this.activationId = activationId;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Users getUser() {
        return user;
    }

    public String getMsg() {
        return msg;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    //END getters and setters

    //return the attributes from  the FORM (JSP)
    public String addUser() {
        login.setUserKey(UUID.randomUUID().toString());
        login.setPassword(encryption(login.getPassword(), login.getUserKey()));
        user.setLogin(login);
        if (userDAO.getUserEmail(login.getEmail()) == false) {
            if (userDAO.add(user)) {
                Session s;
                MimeMessage message;
                Transport transport;
                Properties prop;
                String emailAdd = login.getEmail();
                try {
                    prop = System.getProperties();
                    prop.put("mail.smtp.host", "smtp.mail.yahoo.com");
                    s = Session.getDefaultInstance(prop, null);
                    message = new MimeMessage(s);
                    transport = s.getTransport("smtp");
                    transport.connect("smtp.mail.yahoo.com.au", 587, "Cqudvd@yahoo.com.au", "Cqudvd12345");
                    message.setFrom(new InternetAddress("Cqudvd@yahoo.com.au"));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAdd));
                    message.setSubject("Registration Confirmation");
                    message.setText("Hi " + user.getFirstName() + "\nPlease Confirm your registration by clicking the link below:\n " + "http://localhost:8084/cqu/activate?activationId=" + user.getUserId());
                    transport.sendMessage(message, message.getAllRecipients());
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                //clean beans
                user = new Users();
                login = new Login();
                msg = "Thank you for registering\n Please check your email to activate your account";
            } else {
                msg = "Somethings goes worng, please try it again";
            }
        } else {
            msg = "Someone already has the email address '" + login.getEmail() + "', please try again";
        }
        return "success";
    }

    public String updateUser() {
        user.setUserId(Integer.parseInt(session.get("userId").toString()));
        if (userDAO.updateDetail(user)) {
            session.put("userDescr", user.getLastName() + ", " + user.getFirstName());
        } else {
            msg = "Somethings goes worng, please try it again";
        }
        return "success";
    }

    public String validate() {
        String userKey = userDAO.getUserKey(login.getEmail());
        if (userKey.equals("")) {
            msg = "User does not exits";
        } else {
            login.setPassword(encryption(login.getPassword(), userKey));
            Object[] u = userDAO.validation(login.getEmail(), login.getPassword());
            if (u == null) {
                msg = "user/password error";
            } else {
                if (u[4].toString().equals("P")) {
                    msg = "Your account has not yet been activated,\n Please check your email to activate your account";
                } else {
                    session.put("userId", u[0].toString());
                    session.put("userDescr", u[1].toString());
                    session.put("userEmail", u[2].toString());
                    session.put("userRole", u[3].toString());
                    if (u[3].toString().equals("USER")) {
                        return "welcome";
                    } else {
                        return "admin";
                    }
                }
            }
        }
        return "error";
    }

    public String logout() {
        session.clear();
        return "success";
    }

    public String encryption(String unecryptedPassword, String userKey) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update((unecryptedPassword + userKey).getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return (new BigInteger(messageDigest.digest())).toString(16);

    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public Map<String, Object> getsession() {
        return session;
    }

    public String activate() {
        userDAO.activate(activationId);
        msg = "Your Account has been activated";
        return "success";
    }

    public String userDetail() {
        String id = session.get("userId").toString();
        user = userDAO.usersDetail(id);
        // String fName=uDetail.getFirstName();
        return "userDetail";
    }
}
