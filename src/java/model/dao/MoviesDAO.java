/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import java.util.ArrayList;
import java.util.List;
import model.entities.Movies;
import model.entities.MoviesBuy;
import model.entities.MoviesRent;
import model.entities.Orders;
/**
 *
 * @author cardven
 */
public interface MoviesDAO {
    public ArrayList<Movies> list();
    public ArrayList<Movies> listForBuy();
    public ArrayList<Movies> rentAvailable();    
    public int insert(Movies movie);
    public Movies movieDetail(String id);
    public int updateMovie(Movies movie);
    public boolean delete(String id);
    
    public ArrayList<MoviesBuy> listBuy();
    public MoviesBuy editBuyDetail(String id);
    public MoviesBuy editBuyDetailByMovieId(String id);
    public int updateBuy(MoviesBuy movieBuy);
    public int insertBuy(MoviesBuy movieBuy);
    public boolean deleteBuy(String id);
    
    
    public ArrayList<MoviesRent> listRent();
    public MoviesRent editRentDetail(String id);
    public MoviesRent editRentDetailByMovieId(String id);
    public int updateRentList(MoviesRent movieType);
    public int insertRentMovie(MoviesRent movieRent);
    public boolean deleteRentItem(String id);
    
    public ArrayList<Movies> searchTitle(String search);
    public ArrayList<Movies> searchGenre(String search);
    public ArrayList<Movies> searchYear(String search);
    
    public ArrayList<Movies> listViewCart(List<Integer> sessionList);
    public String insertOrder(String userID, Orders order);
    
    
}
