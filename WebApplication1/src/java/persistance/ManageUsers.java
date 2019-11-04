/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import handler.RequestHandler;
import java.util.ArrayList;
import persistance.models.Movielistings;

/**
 *
 * @author mitta
 */
public class ManageUsers {
    public static void main(String [] args){
        RequestHandler handler = new RequestHandler();
        ArrayList<Movielistings> movies = handler.getMovieSchedule(1);
        Movielistings movie = movies.get(0);
        
        System.out.println(movie.getListId() + " " + movie.getDate());
    }
}
