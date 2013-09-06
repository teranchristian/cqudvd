/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import model.entities.Movies;
import java.util.ArrayList;
import model.entities.Genres;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.dao.GenresDAO;
import model.dao.GenresDaoImpl;
import model.dao.MoviesDAO;
import model.dao.MoviesDAOImpl;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author cardven
 */
public class MovieController  extends ActionSupport implements
        ServletRequestAware {
   private Movies movie=new Movies();
   private String msg;
   private MoviesDAO moviesDAO= new MoviesDAOImpl();
   ArrayList<Movies> list = new ArrayList();
   ArrayList<Genres> listGenre = new ArrayList();
   String itemId;
   private File userImage;
   private String userImageContentType;
   private String userImageFileName; 
   private HttpServletRequest servletRequest;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public ArrayList<Movies> getList() {
        return list;
    }

    public void setList(ArrayList<Movies> list) {
        this.list = list;
    }
    
    public String list(){
        list = moviesDAO.list();
        return "success";
    }

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
    
    
    public String addMovie(){
        GenresDAO g= new GenresDaoImpl();
        listGenre = g.list();
        return "success";
    }        

    public ArrayList<Genres> getListGenre() {
        return listGenre;
    }

    public void setListGenre(ArrayList<Genres> listGenre) {
        this.listGenre = listGenre;
    }
    
    public String insertMovie(){
        int movieId =moviesDAO.insert(movie);
        if (movieId!=0) {
             try {
            String filePath  = servletRequest.getSession().getServletContext().getRealPath("../../web/public/moviepic");         
            File fileToCreate = new File(filePath, movieId+".png"); 
            FileUtils.copyFile(this.userImage, fileToCreate);
             msg = "Movie have been created";            
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
 
           msg = "Somethings goes worng, please try it again";
        }
         }else{
             msg = "Somethings goes worng, please try it again";
         }
        return "success";
        
    }        

    
  public String editMovie() {
        movie = moviesDAO.movieDetail(itemId);
        return "success";
    }

  public String updateMovie() {
        int movieId=moviesDAO.updateMovie(movie);
           if (movieId!=0) {
             try {
            String filePath  = servletRequest.getSession().getServletContext().getRealPath("../../web/public/moviepic");         
            File fileToCreate = new File(filePath, movieId+".png"); 
            FileUtils.copyFile(this.userImage, fileToCreate);
             return "success";      
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage()); 
           msg = "Somethings goes worng, please try it again";
           return "fail";
        }
        }else{
               msg = "Somethings goes worng, please try it again";
            return "fail";
        }
  }

    public String deleteMovie(){
        
      if (moviesDAO.delete(itemId)) {
            msg = "movie deleted";
        } else {
            msg = "Somethings goes worng, please try it again";
        }
        return "success";
      
    }    
 
    public File getUserImage() {
        return userImage;
    }
 
    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }
 
    public String getUserImageContentType() {
        return userImageContentType;
    }
 
    public void setUserImageContentType(String userImageContentType) {
        this.userImageContentType = userImageContentType;
    }
 
    public String getUserImageFileName() {
        return userImageFileName;
    }
 
    public void setUserImageFileName(String userImageFileName) {
        this.userImageFileName = userImageFileName;
    }
 
    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
 
    }

        
    }
    

