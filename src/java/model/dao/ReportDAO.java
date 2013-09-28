/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


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
    public Long movieSold();
    public Long dvdSold();
    public Long movieRented();
    public Long dvdRented();
    public double soldAmount();
    public double rentAmount();
}
