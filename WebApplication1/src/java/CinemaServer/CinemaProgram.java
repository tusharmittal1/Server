/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CinemaServer;

import handler.RequestHandler;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import persistance.models.Movies;
import persistance.models.Movielistings;

/**
 *
 * @author tushar
 */
@WebService(serviceName = "CinemaProgram")
public class CinemaProgram {

    RequestHandler handler = new RequestHandler();
    
    /**
     * Web service operation
     * @param username
     * @param password
     * @return 
     */
    @WebMethod(operationName = "createUser")
    public String createUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return handler.login(username, password);
    }

    /**
     * Web service operation
     * @param username
     * @param password
     * @return 
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") final String username, @WebParam(name = "password") final String password) {
        return handler.login(username, password);
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getMovies")
    public ArrayList<Movies> getMovies() {
        //TODO write your implementation code here:
        return handler.getMovies();
    }
    
    /**
     * Web service operation
     * @param movieId
     * @return
     */
    @WebMethod(operationName = "getMovieSchedule")
    public ArrayList<Movielistings> getMovieSchedule(@WebParam(name = "movieId") final Integer movieId){
        return handler.getMovieSchedule(movieId);
    }
    
}
