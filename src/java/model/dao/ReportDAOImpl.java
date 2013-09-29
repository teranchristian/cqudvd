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

    @Override
    public Long movieSold() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select count(distinct m) from Orders as o left join o.movie as m where type='b'").uniqueResult();
        return value;
    }

    @Override
    public Long dvdSold() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select count(m) from Orders as o left join o.movie as m where type='b'").uniqueResult();
        return value;
    }

    @Override
    public Long movieRented() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select count(distinct m) from Orders as o left join o.movie as m where type='r'").uniqueResult();
        return value;
    }

    @Override
    public Long dvdRented() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long value = (Long) session.createQuery("Select count(m) from Orders as o left join o.movie as m where type='r'").uniqueResult();
        return value;
    }

    @Override
    public double soldAmount() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        double value = (Double) session.createQuery("Select sum(price) from Orders as o where type='b'").uniqueResult();
        return value;
    }

    @Override
    public double rentAmount() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        double value = (Double) session.createQuery("Select sum(price) from Orders as o where type='r'").uniqueResult();
        return value;
    }

}

   
