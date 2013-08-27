/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.entities.Users;
import model.entities.Login;
/**
 *
 * @author christian
 */
public interface UsersDAO {

    public boolean add(Users user);

    public boolean getUserEmail(String email);

    public String getUserKey(String email);

    public Object[] validation(String email, String password);

    public void activate(String id);

    public Users usersDetail(String id);

    public boolean updateDetail(Users user);
    
    public boolean updatePassword(Login login);
}
