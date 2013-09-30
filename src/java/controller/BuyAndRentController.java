/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.MoviesDAO;
import model.dao.MoviesDAOImpl;
import model.entities.Movies;
import model.entities.MoviesBuy;
import model.entities.MoviesRent;
import model.entities.shoppingCart;
import javax.servlet.http.HttpServletResponse;
import model.entities.Orders;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author cardven
 */
public class BuyAndRentController extends ActionSupport implements ServletResponseAware, ServletRequestAware, SessionAware {

    private MoviesDAO moviesDAO = new MoviesDAOImpl();
    ArrayList<MoviesBuy> list = new ArrayList();
    ArrayList<MoviesRent> listRent = new ArrayList();
    ArrayList<Movies> listMovies = new ArrayList();
    String itemId;
    String msg;
    String movieType;
    String userId;
    String confirmation;
    private MoviesBuy movieBuy = new MoviesBuy();
    private MoviesRent movieRent = new MoviesRent();
    private ArrayList<Movies> listForBuy = new ArrayList();
    private ArrayList<Movies> listForRent = new ArrayList();
    private Movies movie = new Movies();
    private Map<String, Object> session;

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public ArrayList<MoviesRent> getListRent() {
        return listRent;
    }

    public void setListRent(ArrayList<MoviesRent> listRent) {
        this.listRent = listRent;
    }

    public MoviesRent getMovieRent() {
        return movieRent;
    }

    public void setMovieRent(MoviesRent movieRent) {
        this.movieRent = movieRent;
    }

    public ArrayList<Movies> getListForRent() {
        return listForRent;
    }

    public void setListForRent(ArrayList<Movies> listForRent) {
        this.listForRent = listForRent;
    }

    public MoviesDAO getMoviesDAO() {
        return moviesDAO;
    }

    public void setMoviesDAO(MoviesDAO moviesDAO) {
        this.moviesDAO = moviesDAO;
    }

    public ArrayList<MoviesBuy> getList() {
        return list;
    }

    public void setList(ArrayList<MoviesBuy> list) {
        this.list = list;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MoviesBuy getMovieBuy() {
        return movieBuy;
    }

    public void setMovieBuy(MoviesBuy movieBuy) {
        this.movieBuy = movieBuy;
    }

    public ArrayList<Movies> getListForBuy() {
        return listForBuy;
    }

    public void setListForBuy(ArrayList<Movies> listForBuy) {
        this.listForBuy = listForBuy;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public ArrayList<Movies> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    // -----------------------------------Buy Movies------------------------
    public String listBuy() {
        list = moviesDAO.listBuy();
        return "success";
    }

    public String editBuy() {
        movieBuy = moviesDAO.editBuyDetail(itemId);
        return "success";
    }

    public String updateBuy() {
        int movieTypeId = moviesDAO.updateBuy(movieBuy);
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
        movieBuy.setMovie(movie);
        int movieTypeId = moviesDAO.insertBuy(movieBuy);
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

    // -----------------------------------Rent Movies------------------------
    public String listRentMovies() {
        listRent = moviesDAO.listRent();
        return "success";
    }

    public String editRentList() {
        movieRent = moviesDAO.editRentDetail(itemId);
        return "success";
    }

    public String updateRentList() {
        int movieRentId = moviesDAO.updateRentList(movieRent);
        if (movieRentId != 0) {
            return "success";
        } else {
            msg = "something is not right";
            return "fail";
        }
    }

    public String addRentList() {
        listForRent = moviesDAO.rentAvailable();
        return "success";
    }

    public String insertRentMovie() {
        movie = moviesDAO.movieDetail("" + movie.getMovieId());
        movieRent.setMovie(movie);
        int movieTypeId = moviesDAO.insertRentMovie(movieRent);
        if (movieTypeId != 0) {
            msg = "Movies has added in rent Categories";
        } else {
            msg = "Something went wrong";
        }
        return "success";
    }

    public String deleteRentItem() {
        if (moviesDAO.deleteRentItem(itemId)) {
            msg = "This movie has been removed from List";
        } else {
            msg = "Somethings goes worng, please try it again";
        }
        return "success";

    }
    //-----------------------Check Out----------------------------------

    public String addCart() {
        int total = 0;
        if (movieType != null) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyyhhmmss");
            String formattedDate = sdf.format(date);
            Cookie c = new Cookie(movieType + "-" + formattedDate, itemId);
            c.setMaxAge(60 * 60 * 24 * 365);
            servletResponse.addCookie(c);
            total++;
        }
        //total shopping cart        
        for (Cookie t : servletRequest.getCookies()) {
            if (t.getName().startsWith("b") || t.getName().startsWith("r")) {
                total++;
            }
        }
        Cookie ctotal = new Cookie("total", Integer.toString(total));
        ctotal.setMaxAge(60 * 60 * 24 * 365);
        servletResponse.addCookie(ctotal);
        return "success";

    }

    public String removeItemCart() {
        boolean delete = false;

        for (Cookie c : servletRequest.getCookies()) {
            if ((c.getName().startsWith(movieType)) && (c.getValue().equals(itemId)) && delete == false) {
                //total++;   

                c.setMaxAge(0);
                servletResponse.addCookie(c);
                delete = true;
            }
        }
        //total shopping cart       
        int total = -1;
        for (Cookie t : servletRequest.getCookies()) {
            if (t.getName().startsWith("buy") || t.getName().startsWith("rent")) {
                total++;
            }
        }
        Cookie ctotal = new Cookie("total", Integer.toString(total));
        ctotal.setMaxAge(60 * 60 * 24 * 365);
        servletResponse.addCookie(ctotal);
        return "success";

    }

    public String viewCart() {

        for (Cookie t : servletRequest.getCookies()) {
            if (t.getName().startsWith("b")) {
                movieBuy = moviesDAO.editBuyDetailByMovieId(t.getValue());
                list.add(movieBuy);
            }
            if (t.getName().startsWith("r")) {
                movieRent = moviesDAO.editRentDetailByMovieId(t.getValue());
                listRent.add(movieRent);
            }
        }
        return "success";

    }

    public String checkout() {
        try {
            String id = session.get("userId").toString();
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
             StringBuilder  confirmationNumber = new StringBuilder();
        confirmationNumber.append("CQU");
            for (Cookie t : servletRequest.getCookies()) {
                Orders or = new Orders();
                or.setUserId(Integer.parseInt(id));
                or.setCode(id+"-"+timeStamp);
                if (t.getName().startsWith("b")) {
                    movieBuy = moviesDAO.editBuyDetailByMovieId(t.getValue());
                    int Stock = movieBuy.getStock() - 1;
                    movieBuy.setStock(Stock);
                    int movieTypeId = moviesDAO.updateBuy(movieBuy);
                    or.setMovie(movieBuy.getMovie());
                    or.setType("b");
                    or.setTypeId(movieBuy.getMoviesBuyId());
                    or.setPrice(movieBuy.getPrice());
                    
                   int Id= moviesDAO.insertOrder(or);
                   confirmationNumber.append(Id+"-"); 
                    //list.add(movieBuy);
                }
                if (t.getName().startsWith("r")) {
                    movieRent = moviesDAO.editRentDetailByMovieId(t.getValue());
                    or.setMovie(movieRent.getMovie());
                    or.setType("r");
                    or.setTypeId(movieRent.getMovieRentId());
                    or.setPrice(movieRent.getPrice());
                    int rStock = movieRent.getStock() - 1;
                    int unitRented = movieRent.getRented() + 1;
                    movieRent.setStock(rStock);
                    movieRent.setRented(unitRented);
                    moviesDAO.updateRentList(movieRent);
                    int Id =moviesDAO.insertOrder(or);
                    confirmationNumber.append(Id+"-"); 
                    
                }
                
            }
            
            Cookie[] cookies = servletRequest.getCookies();
       if (cookies != null)
        for (int i = 0; i < cookies.length; i++) {
            cookies[i].setValue(null);
            cookies[i].setPath("/cqu");
            cookies[i].setMaxAge(0);
            servletResponse.addCookie(cookies[i]);
        }
       
            msg = confirmationNumber.toString();
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
    protected HttpServletResponse servletResponse;

    @Override
    public void setServletResponse(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }
    protected HttpServletRequest servletRequest;

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public Map<String, Object> getsession() {
        return session;
    }
}
