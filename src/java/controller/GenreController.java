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
    String itemId;

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
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
    public String addGenre() {
        return "success";
    }
  
    public String insertGenre() {
         if (genreDao.add(genre)) {
             msg = "Genre inserted";
         }else{
             msg = "Somethings goes worng, please try it again";
         }
        return "success";
    }
  public String deleteGenre() {
      if (genreDao.delete(itemId)) {
            msg = "genre deleted";
        } else {
            msg = "Somethings goes worng, please try it again";
        }
        return "success";
    }
  public String editGenre() {
        genre = genreDao.genreDetail(itemId);
        return "success";
    }
  public String updateGenre() {
        if (genreDao.update(genre)){
            return "success";
        }else{
            return "fail";
        }
        
    }
    
}
