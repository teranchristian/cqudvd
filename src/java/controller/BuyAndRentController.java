/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.dao.MoviesDAO;
import model.dao.MoviesDAOImpl;
import model.entities.Movies;
import model.entities.MoviesBuy;
import model.entities.MoviesRent;

/**
 *
 * @author cardven
 */
public class BuyAndRentController {
    private MoviesDAO moviesDAO=new MoviesDAOImpl();
    ArrayList<MoviesBuy> list = new ArrayList();
    ArrayList<MoviesRent> listRent = new ArrayList();
    String itemId;
    String msg;
    private MoviesBuy movieBuy  = new MoviesBuy();
    private MoviesRent movieRent  = new MoviesRent();
    private ArrayList<Movies> listForBuy = new ArrayList();
    private ArrayList<Movies> listForRent = new ArrayList();
    private Movies movie = new Movies();

    public ArrayList<MoviesRent> getListRent() {
        return listRent;
    }

    public void setListRent(ArrayList<MoviesRent> listRent) {
        this.listRent = listRent;
    }

    public MoviesRent getMovieRent() {
        return movieRent;
    }

    public void setMovieRent(MoviesRent movieRent) {
        this.movieRent = movieRent;
    }

    public ArrayList<Movies> getListForRent() {
        return listForRent;
    }

    public void setListForRent(ArrayList<Movies> listForRent) {
        this.listForRent = listForRent;
    }
    
    
    
    public MoviesDAO getMoviesDAO() {
        return moviesDAO;
    }

    public void setMoviesDAO(MoviesDAO moviesDAO) {
        this.moviesDAO = moviesDAO;
    }

    public ArrayList<MoviesBuy> getList() {
        return list;
    }

    public void setList(ArrayList<MoviesBuy> list) {
        this.list = list;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MoviesBuy getMovieBuy() {
        return movieBuy;
    }

    public void setMovieBuy(MoviesBuy movieBuy) {
        this.movieBuy = movieBuy;
    }

    public ArrayList<Movies> getListForBuy() {
        return listForBuy;
    }

    public void setListForBuy(ArrayList<Movies> listForBuy) {
        this.listForBuy = listForBuy;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }
    
    
    
    
    
    // -----------------------------------Buy Movies------------------------
    public String listBuy() {
        list = moviesDAO.listBuy();
        return "success";
    }

    public String editBuy() {
        movieBuy = moviesDAO.buyDetail(itemId);
        return "success";
    }

    public String updateBuy() {
        int movieTypeId = moviesDAO.updateBuy(movieBuy);
        if (movieTypeId != 0) {
            return "success";
        } else {
            msg = "something is not right";
            return "fail";
        }
    }

    public String addBuy() {
        listForBuy = moviesDAO.listForBuy();
        return "success";
    }

    public String insertBuy() {
        movie = moviesDAO.movieDetail("" + movie.getMovieId());
        movieBuy.setMovie(movie);
        int movieTypeId = moviesDAO.insertBuy(movieBuy);
        if (movieTypeId != 0) {
            msg = "Movies has created into Buy Categories";
        } else {
            msg = "Something went wrong";
        }
        return "success";
    }

    public String deleteBuy() {
        if (moviesDAO.deleteBuy(itemId)) {
            msg = "movie deleted from Buy";
        } else {
            msg = "Somethings goes worng, please try it again";
        }
        return "success";

    }

       // -----------------------------------Rent Movies------------------------
    public String listRentMovies() {
        listRent = moviesDAO.listRent();
        return "success";
    }

    public String editRentList() {
        movieRent = moviesDAO.editRentDetail(itemId);
        return "success";
    }
    
    public String updateRentList() {
        int movieRentId = moviesDAO.updateRentList(movieRent);
        if (movieRentId != 0) {
            return "success";
        } else {
            msg = "something is not right";
            return "fail";
        }
    }
    
    public String addRentList() {
        listForRent = moviesDAO.rentAvailable();
        return "success";
    }

    public String insertRentMovie() {
        movie = moviesDAO.movieDetail("" + movie.getMovieId());
        movieRent.setMovie(movie);
        int movieTypeId = moviesDAO.insertRentMovie(movieRent);
        if (movieTypeId != 0) {
            msg = "Movies has added in rent Categories";
        } else {
            msg = "Something went wrong";
        }
        return "success";
    }
    
    public String deleteRentItem() {
        if (moviesDAO.deleteRentItem(itemId)) {
            msg = "This movie has been removed from List";
        } else {
            msg = "Somethings goes worng, please try it again";
        }
        return "success";

    }
    
}
