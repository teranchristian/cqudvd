/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.entities.Movies;
import java.util.ArrayList;
import java.util.List;
import model.entities.MoviesBuy;
import model.entities.MoviesRent;
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
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            ArrayList<Movies> lm = (ArrayList<Movies>) session.createQuery("from Movies where active='T'").list();
            //session.close();
            return lm;

        } catch (Exception e) {
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
        Movies m = (Movies) session.createQuery("from Movies where movieId =" + id).uniqueResult();
        session.close();
        return m;
    }

    @Override
    public int updateMovie(Movies movie) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.update(movie);
            session.flush();
            transaction.commit();
            session.close();
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
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public ArrayList<MoviesBuy> listBuy() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<MoviesBuy> lmb = (ArrayList<MoviesBuy>) session.createQuery("from MoviesBuy m where m.active='T'").list();
        //session.close();
        return lmb;
    }

    @Override
    public MoviesBuy editBuyDetail(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        MoviesBuy mb = (MoviesBuy) session.createQuery("from MoviesBuy where moviesBuyId =" + id).uniqueResult();
        session.close();
        return mb;
    }

    @Override
    public MoviesBuy editBuyDetailByMovieId(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        MoviesBuy mb = (MoviesBuy) session.createQuery("from MoviesBuy as mb where mb.movie.movieId=" + id).uniqueResult();
        session.close();
        return mb;
    }

    @Override
    public int updateBuy(MoviesBuy movieBuy) {
        try {
            int id = movieBuy.getMoviesBuyId();

            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query update = session.createQuery("update MoviesBuy u set u.price = " + movieBuy.getPrice() + ",u.stock=" + movieBuy.getStock() + " where u.moviesBuyId =" + id);
            update.executeUpdate();
            session.flush();
            transaction.commit();
            session.close();
            return movieBuy.getMoviesBuyId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return 0;
        }
    }

    @Override
    public int insertBuy(MoviesBuy movieBuy) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(movieBuy);
            session.flush();
            transaction.commit();
            session.close();
            return movieBuy.getMoviesBuyId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return 0;
        }
    }

    @Override
    public boolean deleteBuy(String id) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query update = session.createQuery("update MoviesBuy  set active ='F'  where moviesBuyId =" + id);
            update.executeUpdate();
            transaction.commit();
            session.close();
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
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            ArrayList<Movies> lm = (ArrayList<Movies>) session.createQuery("Select m from MoviesBuy as mb right join mb.movie as m where m.active = 'T' AND mb.movie is Null").list();
            //session.close();
            return lm;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Movies> searchTitle(String search) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<Movies> lm = (ArrayList<Movies>) session.createQuery("from Movies where active='T' and lower(movieTitle) like'%" + search + "%'").list();
        //session.close();
        return lm;
    }

    @Override
    public ArrayList<Movies> searchGenre(String search) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<Movies> lm = (ArrayList<Movies>) session.createQuery("from Movies m where m.active='T' and lower(m.genre.genre) like'%" + search + "%'").list();
        //session.close();
        return lm;
    }

    @Override
    public ArrayList<Movies> searchYear(String search) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<Movies> lm = (ArrayList<Movies>) session.createQuery("from Movies where active='T' and releaseYear =" + search).list();
        //session.close();
        return lm;
    }

    @Override
    public ArrayList<MoviesRent> listRent() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<MoviesRent> lmr = (ArrayList<MoviesRent>) session.createQuery("from MoviesRent m where m.active='T'").list();
        // session.close();
        return lmr;
    }

    @Override
    public MoviesRent editRentDetail(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        MoviesRent mr = (MoviesRent) session.createQuery("from MoviesRent where movieRentId =" + id).uniqueResult();
        session.close();
        return mr;
    }

    @Override
    public MoviesRent editRentDetailByMovieId(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        MoviesRent mr = (MoviesRent) session.createQuery("from MoviesRent as mr where mr.movie.movieId=" + id).uniqueResult();
        session.close();
        return mr;
    }

    @Override
    public int updateRentList(MoviesRent movieRent) {
        try {
            int id = movieRent.getMovieRentId();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query update = session.createQuery("update MoviesRent rm set rm.price = " + movieRent.getPrice() + ",rm.stock=" + movieRent.getStock() + ",rm.rented=" + movieRent.getRented() + " where rm.movieRentId =" + id);
            update.executeUpdate();
            session.flush();
            transaction.commit();
            session.close();
            return movieRent.getMovieRentId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return 0;
        }
    }

    @Override
    public ArrayList<Movies> rentAvailable() {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            ArrayList<Movies> lm = (ArrayList<Movies>) session.createQuery("Select m from MoviesRent as mb right join mb.movie as m where m.active = 'T' AND mb.movie is Null").list();
            //session.close();
            return lm;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int insertRentMovie(MoviesRent movieRent) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(movieRent);
            session.flush();
            transaction.commit();
            session.close();
            return movieRent.getMovieRentId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return 0;
        }

    }

    @Override
    public boolean deleteRentItem(String id) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Query update = session.createQuery("update MoviesRent  set active ='F'  where movieRentId =" + id);
            update.executeUpdate();
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public ArrayList<Movies> listViewCart(List<Integer> sessionList) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            ArrayList<Movies> lm = new ArrayList<Movies>();
            for (Integer id : sessionList) {
                Movies m = (Movies) session.createQuery("from Movies where movieId =" + id).uniqueResult();
                lm.add(m);
            }

          //  ArrayList<Movies> lm = (ArrayList<Movies>) session.createQuery("Select m from MoviesRent as mb right join mb.movie as m where m.active = 'T' AND mb.movie is Null").list();
            //session.close();
            return lm;
        } catch (Exception e) {
            return null;
        }
    }
}
