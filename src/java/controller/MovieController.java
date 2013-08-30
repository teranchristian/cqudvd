/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.entities.Movies;
import java.util.ArrayList;
import java.util.Map;
import model.dao.MoviesDAO;
import model.dao.MoviesDAOImpl;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author cardven
 */
public class MovieController  {
   private Movies movie=new Movies();
   private String msg;
   private MoviesDAO moviesDAO= new MoviesDAOImpl();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }
    
    public String list(){
        return "success";
    }
    public String addMovie(){
        return "success";
    }        
    
    public String insertMovie(){
        if (moviesDAO.insert(movie)) {
             msg = "Movie inserted";
         }else{
             msg = "Somethings goes worng, please try it again";
         }
        return "success";
        
    }        

    
    
    
}
