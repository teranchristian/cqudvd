/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import model.entities.Movies;
import model.entities.MoviesBuy;
import model.entities.MoviesRent;
/**
 *
 * @author Admin
 */
public interface ReportDAO {
    
    public Long totBuyMovie();
    public Long totBuyDVD();
    public Long totRentMovie();
    public Long totRentDVD();
    public Long totRentedDVD();
    public Long totDVDStock();
    
}
