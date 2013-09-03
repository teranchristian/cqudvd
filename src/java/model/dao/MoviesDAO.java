/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import java.util.ArrayList;
import model.entities.Movies;
/**
 *
 * @author cardven
 */
public interface MoviesDAO {
    public ArrayList<Movies> list();
    public int insert(Movies movie);
    public Movies movieDetail(String id);
    public int updateMovie(Movies movie);
    public boolean delete(String id);
}
