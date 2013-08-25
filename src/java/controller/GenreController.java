/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.dao.GenresDAO;
import model.dao.GenresDaoImpl;
import model.entities.Genres;



/**
 *
 * @author christian
 */
public class GenreController  {

    Genres genre = new Genres();
    ArrayList<Genres> genreList = new ArrayList();
    GenresDAO genreDao;
    String msg;
    
    public GenreController(){
        genreDao= new GenresDaoImpl();
    }
    
    
    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public String getMsg() {
        return msg;
    }

    public ArrayList<Genres> getGenreList() {
        return genreList;
    }

    //End Getters and Setters
    
    public String genreList() {
        genreList = genreDao.list();
        return "success";
    }

    
}
