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
    public boolean insert(Movies movie);
    public boolean delete(String id);
}
