/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import org.hibernate.Session;
    
/**
 *
 * @author Admin
 */
public class ReportDAOImpl implements ReportDAO{
    
    private Session session;

    @Override
    public Long totBuyMovie() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select count(distinct m.movie) from MoviesBuy as m where m.active='T'").uniqueResult();
        return value;
    }
    
    
    @Override
    public Long totBuyDVD() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select sum(m.stock) from MoviesBuy as m").uniqueResult();
        return value;
    }

    @Override
    public Long totRentMovie() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select count(distinct m.movie) from MoviesRent as m where m.active='T'").uniqueResult();
        return value;
    }
    
    @Override
    public Long totRentDVD() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select sum(m.stock) from MoviesRent as m").uniqueResult();
        return value;
    }
    
    @Override
    public Long totRentedDVD() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select sum(m.rented) from MoviesRent as m").uniqueResult();
        return value;
    }

    @Override
    public Long totDVDStock() {
        Long value;
        value = this.totBuyDVD() + this.totRentDVD();
        return value;
    }
}

   
