/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.entities.Movies;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

/**
 *
 * @author cardven
 */
public class MoviesDAOImpl implements MoviesDAO {
    private Session session;
    private Transaction transaction;
    
    
    
    @Override
    public ArrayList<Movies> list() {
    return list();    
    }

    @Override
    public boolean insert(Movies movie) {
     try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(movie);
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
