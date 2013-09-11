/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import java.util.ArrayList;
import model.entities.Movies;
import model.entities.MoviesType;
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
    public ArrayList<MoviesType> listBuy();
    public MoviesType buyDetail(String id);
    public int updateBuy(MoviesType movieType);
    public int insertBuy(MoviesType movieType);
    public boolean deleteBuy(String id);
    
    
    public ArrayList<MoviesType> listRent();
    public MoviesType editTypeDetail(String id);
    public int updateRentList(MoviesType movieType);
    public int insertRentMovie(MoviesType movieType);
    public boolean deleteRentItem(String id);
    
    public ArrayList<Movies> searchTitle(String search);
    public ArrayList<Movies> searchGenre(String search);
    public ArrayList<Movies> searchYear(String search);
    
    
    
}
