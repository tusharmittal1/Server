/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import daos.MoviesDao;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistance.models.Movies;
import persistance.models.Movielistings;

/**
 *
 * @author mitta
 */
public class MoviesDaoImpl implements MoviesDao{

    @Override
    public ArrayList<Movies> get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Movies> movies = null;
        
        try{
            tx = session.beginTransaction();
            movies = (ArrayList<Movies>) session.createQuery("FROM Movies").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return movies;
    }  

    @Override
    public ArrayList<Movielistings> getMovieSchedule(int movieId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Movielistings> movieListings = null;
        
        try{
            tx = session.beginTransaction();
            String sql = "SELECT * FROM movieListings WHERE movieId = :movieId";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Movielistings.class);
            query.setParameter("movieId", movieId);
            movieListings = (ArrayList<Movielistings>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return movieListings;
    }
}