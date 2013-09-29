/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author christian
 */
public class shoppingCart {

    private int movieId;
    private String movieType;

    /*
     * Default constractor
     */
    public shoppingCart() {
    }

    /*
     * Constractor with param
     */
    public shoppingCart(int movieId, String movieType) {
        this.movieId = movieId;
        this.movieType = movieType;
    }

    /*
     * Getter and Setter
     */
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }
}
