/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.entities.Genres;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author christian
 */
public class GenresDaoImpl implements GenresDAO {

    Transaction transaction;
    Session session;

    @Override
    public ArrayList<Genres> list() {
        try{
             session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            return (ArrayList<Genres>)session.createQuery("from Genres where active='T'").list();
            
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean add(Genres genre) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(genre);
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
