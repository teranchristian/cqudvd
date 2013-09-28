/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dao.ReportDAO;
import model.dao.ReportDAOImpl;
/**
 *
 * @author Admin
 */
    
public class ReportController {
    
Long value1;
Long value2;
Long value3;
Long value4;
Long value5;
Long value6;
double value7;
double value8;

private ReportDAO reportDAO = new ReportDAOImpl();
    
    public Long getValue1() {
        return value1;
    }

    public void setValue1(Long value1) {
        this.value1 = value1;
    }

    public Long getValue2() {
        return value2;
    }

    public void setValue2(Long value2) {
        this.value2 = value2;
    }

    public Long getValue3() {
        return value3;
    }

    public void setValue3(Long value3) {
        this.value3 = value3;
    }

    public Long getValue4() {
        return value4;
    }

    public void setValue4(Long value4) {
        this.value4 = value4;
    }

    public Long getValue5() {
        return value5;
    }

    public void setValue5(Long value5) {
        this.value5 = value5;
    }

    public Long getValue6() {
        return value6;
    }

    public void setValue6(Long value6) {
        this.value6 = value6;
    }

    public double getValue7() {
        return value7;
    }

    public void setValue7(double value7) {
        this.value7 = value7;
    }

    public double getValue8() {
        return value8;
    }

    public void setValue8(double value8) {
        this.value8 = value8;
    }


    public String stockReport()
    {
        value1 = reportDAO.totBuyMovie();
        value2 = reportDAO.totBuyDVD();
        value3 = reportDAO.totRentMovie();
        value4 = reportDAO.totRentDVD();
        value5 = reportDAO.totRentedDVD();
        value6 = reportDAO.totDVDStock();
        return "success";
    }
    
    public String salesReport()
    {
        value1 = reportDAO.movieSold();
        value2 = reportDAO.dvdSold();
        
        value3 = reportDAO.movieRented();
        value4 = reportDAO.dvdRented();
        
        value7 = reportDAO.soldAmount();
        value8 = reportDAO.rentAmount();
        return "success";
    }
}
