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
import model.entities.MoviesType;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author cardven
 */
public class MovieController extends ActionSupport implements ServletRequestAware {

    private Movies movie = new Movies();
    private String msg;
    private MoviesDAO moviesDAO = new MoviesDAOImpl();
    ArrayList<Movies> list = new ArrayList();
    ArrayList<MoviesType> listType = new ArrayList();
    ArrayList<Genres> listGenre = new ArrayList();
    String itemId;
    String searchType;
    String searchInput;
    private MoviesType movieType = new MoviesType();
    private ArrayList<Movies> listForBuy = new ArrayList();
    private File userImage;
    private String userImageContentType;
    private String userImageFileName;
    private HttpServletRequest servletRequest;

    public ArrayList<Movies> getListForBuy() {
        return listForBuy;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public void setListForBuy(ArrayList<Movies> listForBuy) {
        this.listForBuy = listForBuy;
    }

    public MoviesType getMovieType() {
        return movieType;
    }

    public void setMovieType(MoviesType movieType) {
        this.movieType = movieType;
    }

    public ArrayList<MoviesType> getListType() {
        return listType;
    }

    public void setListType(ArrayList<MoviesType> listType) {
        this.listType = listType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

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

    public void setListGenre(ArrayList<Genres> listGenre) {
        this.listGenre = listGenre;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }
    //---End getters-setters

    public String list() {
        list = moviesDAO.list();
        return "success";
    }

    public String addMovie() {
        GenresDAO g = new GenresDaoImpl();
        listGenre = g.list();
        return "success";
    }

    public ArrayList<Genres> getListGenre() {
        return listGenre;
    }

    public String insertMovie() {
        int movieId = moviesDAO.insert(movie);
        GenresDAO g = new GenresDaoImpl();
        listGenre = g.list();
        if (movieId != 0) {
            try {
                String filePath = servletRequest.getSession().getServletContext().getRealPath("../../web/public/moviepic");
                File fileToCreate = new File(filePath, movieId + ".png");
                String buildPath = servletRequest.getSession().getServletContext().getRealPath("/web/public/moviepic");

                File fileToCreateBuild = new File(buildPath, movieId + ".png");

                FileUtils.copyFile(this.userImage, fileToCreate);
                FileUtils.copyFile(this.userImage, fileToCreateBuild);
                msg = "Movie Title '" + movie.getMovieTitle() + "'have been created";
                movie = new Movies();
            } catch (Exception e) {
                e.printStackTrace();
                addActionError(e.getMessage());
                msg = "Somethings goes worng, please try it again";
            }
        } else {

            msg = "Somethings goes worng, please try it again";
        }
        return "success";

    }

    public String editMovie() {
        movie = moviesDAO.movieDetail(itemId);
        GenresDAO g = new GenresDaoImpl();
        listGenre = g.list();
        return "success";
    }

    public String updateMovie() {
        int movieId = moviesDAO.updateMovie(movie);
        GenresDAO g = new GenresDaoImpl();
        listGenre = g.list();
        if (movieId != 0) {
            try {
                String filePath = servletRequest.getSession().getServletContext().getRealPath("../../web/public/moviepic");
                String buildPath = servletRequest.getSession().getServletContext().getRealPath("/public/moviepic");

                File fileToCreateBuild = new File(buildPath, movieId + ".png");
                if (fileToCreateBuild.exists()) {
                    fileToCreateBuild.delete();
                }

                File fileToCreate = new File(filePath, movieId + ".png");
                if (fileToCreate.exists()) {
                    fileToCreate.delete();
                }

                System.out.println("\n\nthe path is \n" + fileToCreateBuild);
                FileUtils.copyFile(this.userImage, fileToCreate);
                FileUtils.copyFile(this.userImage, fileToCreateBuild);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                addActionError(e.getMessage());
                msg = "Somethings goes worng, please try it again";
                return "fail";
            }
        } else {
            msg = "Somethings goes worng, please try it again";
            return "fail";
        }
    }

    public String deleteMovie() {
        if (moviesDAO.delete(itemId)) {
            msg = "movie deleted";
        } else {
            msg = "Somethings goes worng, please try it again";
        }
        return "success";

    }

    // -----------------------------------Buy Movies------------------------
    public String listBuy() {
        listType = moviesDAO.listBuy();
        return "success";
    }

    public String editBuy() {
        movieType = moviesDAO.buyDetail(itemId);

        return "success";
    }

    public String updateBuy() {
        int movieTypeId = moviesDAO.updateBuy(movieType);
        if (movieTypeId != 0) {
            return "success";
        } else {
            msg = "something is not right";
            return "fail";
        }
    }

    public String addBuy() {
        listForBuy = moviesDAO.listForBuy();
        return "success";
    }

    public String insertBuy() {
        movie = moviesDAO.movieDetail("" + movie.getMovieId());
        movieType.setMovie(movie);
        movieType.setMovieType("BUY");
        int movieTypeId = moviesDAO.insertBuy(movieType);
        if (movieTypeId != 0) {
            msg = "Movies has created into Buy Categories";
        } else {
            msg = "Something went wrong";
        }
        return "success";
    }

    public String deleteBuy() {
        if (moviesDAO.deleteBuy(itemId)) {
            msg = "movie deleted from Buy";
        } else {
            msg = "Somethings goes worng, please try it again";
        }
        return "success";

    }

    // -----------------------------------Search Movies------------------------     
    public String searchMovie() {

        if (!searchInput.equals("")) {
            if (searchType.endsWith("T")) {
                list = moviesDAO.searchTitle(searchInput.toLowerCase());
            } else if (searchType.endsWith("G")) {
                list = moviesDAO.searchGenre(searchInput.toLowerCase());
            } else {
                list = moviesDAO.searchYear(searchInput.toLowerCase());
            }
        }
        return "success";

    }
}
