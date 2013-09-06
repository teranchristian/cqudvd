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
    public int insert(Movies movie);
    public Movies movieDetail(String id);
    public int updateMovie(Movies movie);
    public boolean delete(String id);
    public ArrayList<MoviesType> listBuy();
    public MoviesType buyDetail(String id);
    public int updateBuy(MoviesType movieType);
    public int insertBuy(MoviesType movieType);
    public boolean deleteBuy(String id);
    
    
    
}
