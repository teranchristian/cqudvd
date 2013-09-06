/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.entities.Genres;

/**
 *
 * @author christian
 */
public interface GenresDAO {
    public  ArrayList<Genres> list();
    public boolean add(Genres genre);
    public boolean delete(String id);
    public Genres genreDetail(String id);
    public boolean update(Genres genre);
    
}
