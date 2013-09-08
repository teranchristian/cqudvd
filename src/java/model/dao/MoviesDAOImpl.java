/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.entities.Movies;
import java.util.ArrayList;
import model.entities.MoviesType;
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
    public int insert(Movies movie) {
     try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(movie);
            session.flush(); 
            transaction.commit();
            
            return movie.getMovieId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return 0;
        }
        
    }
    
    @Override
    public Movies movieDetail(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        return (Movies) session.createQuery("from Movies where movieId =" + id).uniqueResult();
    }
    

    @Override
    public int updateMovie(Movies movie) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.update(movie);
            session.flush(); 
            transaction.commit();
            return movie.getMovieId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return 0;
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

    @Override
    public ArrayList<MoviesType> listBuy() {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            return (ArrayList<MoviesType>)session.createQuery("from MoviesType m where m.movieType='BUY' AND m.active='T'").list();
    }

    @Override
    public MoviesType buyDetail(String id) {
    session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        return (MoviesType) session.createQuery("from MoviesType where movieTypeId =" + id).uniqueResult();
    }

    @Override
    public int updateBuy(MoviesType movieType) {
    try {
            int id = movieType.getMovieTypeId();
        
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query update = session.createQuery("update MoviesType u set u.price = "+movieType.getPrice()+",u.stock="+movieType.getStock() + " where u.movieTypeId =" + id);
            update.executeUpdate();
            session.flush(); 
            transaction.commit();
            return movieType.getMovieTypeId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return 0;
        }
    }

    @Override
    public int insertBuy(MoviesType movieType) {
    try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(movieType);
            session.flush(); 
            transaction.commit();
            
            return movieType.getMovieTypeId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return 0;
        }}

    @Override
    public boolean deleteBuy(String id) {
    try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query update = session.createQuery("update MoviesType  set active ='F'  where movieTypeId =" + id);
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
    public ArrayList<Movies> listForBuy() {
    try{
             session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            return (ArrayList<Movies>)session.createQuery("SELECT distinct mt from MoviesType as m right outer join m.movie as mt where (m.movieType is Null OR m.movieType='RENT' )and mt.active='T'").list();
            
        }
        catch(Exception e){
            return null;
        }  
    }

    
}
