/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import persistance.models.Movies;
import persistance.models.Movielistings;

/**
 *
 * @author mitta
 */
public interface MoviesDao {

    /**
     *
     * @return
     */
    ArrayList<Movies> get();
    
    /**
     *
     * @param movieId
     * @return
     */
    ArrayList<Movielistings> getMovieSchedule(int movieId);
}
