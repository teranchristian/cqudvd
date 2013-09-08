/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Random;
import model.dao.MoviesDAO;
import model.dao.MoviesDAOImpl;
import model.entities.Movies;

/**
 *
 * @author christian
 */
public class ActionLinkController {
    ArrayList<Movies> list = new ArrayList();
    ArrayList<Movies> listRandom = new ArrayList();

    public ArrayList<Movies> getList() {
        return list;
    }

    

    public String welcome() {
        Random randomGenerator = new Random();        
        MoviesDAO m = new MoviesDAOImpl();
        listRandom =m.list();
        for (int i=0; i<3;i++){
            int index = randomGenerator.nextInt(listRandom.size());
            list.add(listRandom.get(index));        
        }
        return "welcome";
    }

    public String login() {
        return "login";
    }

    public String signUp() {
        return "signUp";
    }
    

}
