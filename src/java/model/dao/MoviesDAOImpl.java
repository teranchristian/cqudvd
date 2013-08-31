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
    private String updateId;
    
    
    
    @Override
    public ArrayList<Movies> list() {
    try{
             session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            return (ArrayList<Movies>)session.createQuery("from Movies where active='T'").list();
            
        }
        catch(Exception e){
            return null;
        }  
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
    
    @Override
    public Movies movieDetail(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        return (Movies) session.createQuery("from Movies where movieId =" + id).uniqueResult();
    }
    

    @Override
    public boolean updateMovie(Movies movie) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.update(movie);
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
    public boolean delete(String id) {
    try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query update = session.createQuery("update Movies  set active ='F'  where movieId =" + id);
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
