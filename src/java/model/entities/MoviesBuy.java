package model.entities;
// Generated 11/09/2013 3:26:34 PM by Hibernate Tools 3.2.1.GA

/**
 * MoviesBuy generated by hbm2java
 */
public class MoviesBuy implements java.io.Serializable {

    private int moviesBuyId;
    private double price;
    private Integer stock;
    private String active;
    private Movies movie;

    /*
     * Default constractor
     */
    public MoviesBuy() {
    }

    /*
     * Constractor with param
     */
    public MoviesBuy(int moviesBuyId, double price) {
        this.moviesBuyId = moviesBuyId;
        this.price = price;
    }

    /*
     * Constractor with param
     */
    public MoviesBuy(int moviesBuyId, double price, Integer stock, String active) {
        this.moviesBuyId = moviesBuyId;
        this.price = price;
        this.stock = stock;
        this.active = active;
    }

    /*
     * Getter and Setter
     */
    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public int getMoviesBuyId() {
        return this.moviesBuyId;
    }

    public void setMoviesBuyId(int moviesBuyId) {
        this.moviesBuyId = moviesBuyId;
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

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
