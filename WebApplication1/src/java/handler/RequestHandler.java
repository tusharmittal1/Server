/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import daos.UsersDao;
import java.util.ArrayList;
import persistance.MoviesDaoImpl;
import persistance.UsersDaoImpl;
import persistance.models.Movies;
import persistance.models.Users;
import persistance.models.Movielistings;

/**
 *
 * @author mitta
 */
public class RequestHandler {
    
    public String login(String username,String password){
        UsersDao dao = new UsersDaoImpl();
        
        Users user;
        user = dao.get(username, password);
        if(user == null){
            return "DOESNT_EXIST";
        }else if (user.getTypeOfUser() == 'C'){
            return "CUSTOMER";
        }else {
            return "MANAGER";
        }
    }
    
    public String createUser(String username, String password){
        if(login(username, password).equals("DOESNT_EXIST")){
            UsersDao dao = new UsersDaoImpl();
            Users user = new Users(username, password, 'C');
            
            Integer userID = dao.create(user);
            if(userID == null){
                return "ERROR";
            }else{
                return userID.toString();
            }
        }else {
            return "ALREADY_EXISTS";
        }
    }

    public ArrayList<Movies> getMovies() {
        MoviesDaoImpl dao = new MoviesDaoImpl();
        return dao.get();
    }

    public ArrayList<Movielistings> getMovieSchedule(int movieId) {
        MoviesDaoImpl dao = new MoviesDaoImpl();
        return dao.getMovieSchedule(movieId);
    }
    
}
