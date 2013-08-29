/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.entities.Login;
import model.entities.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author christian
 */
public class UsersDaoImpl implements UsersDAO {

    Transaction transaction;
    Session session;

    public boolean add(Users users) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(users);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean getUserEmail(String email) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        if (session.createQuery("from Login where Email='" + email + "' ").uniqueResult() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getUserKey(String email) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String userKey = (String) session.createQuery("SELECT userKey from Login where Email='" + email + "' ").uniqueResult();
        if (userKey == null) {
            return "";
        } else {
            return userKey;
        }
    }

    @Override
    public Object[] validation(String email, String password) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return (Object[]) session.createQuery("Select u.userId, u.lastName ||', ' || u.firstName, login.email,  u.role.roleType, u.active from Users u where u.login.email='" + email + "' and u.login.password='" + password + "'  ").uniqueResult();
    }

    @Override
    public void activate(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        Query update = session.createQuery("update Users u set u.active = 'T'" + " where u.userId =" + id);
        update.executeUpdate();
        transaction.commit();
    }

    @Override
    public Users usersDetail(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        return (Users) session.createQuery("from Users u " + "where u.userId =" + id).uniqueResult();
   }

    @Override
    public boolean updateDetail(Users user) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            String id = "" + user.getUserId();
            Query update = session.createQuery("update Users u set u.firstName ='" + user.getFirstName() + "', u.lastName='" + user.getLastName()
                    + "', u.phoneNumber='" + user.getPhoneNumber() + "', u.address='" + user.getAddress() + "' where u.userId =" + id);
            update.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean updatePassword(Login login) {
         try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            
            Query update = session.createQuery("update Login l set l.password='"+login.getPassword()+"', l.userKey='"+login.getUserKey()+"' where l.email='"+login.getEmail()+"'");
            update.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }
}
