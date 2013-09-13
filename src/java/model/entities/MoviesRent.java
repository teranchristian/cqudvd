package model.entities;
// Generated 13/09/2013 10:29:07 AM by Hibernate Tools 3.2.1.GA



/**
 * MoviesRent generated by hbm2java
 */
public class MoviesRent  implements java.io.Serializable {


     private int movieRentId;
     private double price;
     private Integer stock;
     private Integer rented;     
     private Movies movie;
     private String active;

    public MoviesRent() {
    }

	
    public MoviesRent(int movieRentId, double price) {
        this.movieRentId = movieRentId;
        this.price = price;
    }
    public MoviesRent(int movieRentId, double price, Integer stock, Integer rented, String active) {
       this.movieRentId = movieRentId;
       this.price = price;
       this.stock = stock;
       this.rented = rented;
       this.active = active;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }   
    
    
    public int getMovieRentId() {
        return this.movieRentId;
    }
    
    public void setMovieRentId(int movieRentId) {
        this.movieRentId = movieRentId;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Integer getRented() {
        return this.rented;
    }
    
    public void setRented(Integer rented) {
        this.rented = rented;
    }
    
    public String getActive() {
        return this.active;
    }
    
    public void setActive(String active) {
        this.active = active;
    }




}


