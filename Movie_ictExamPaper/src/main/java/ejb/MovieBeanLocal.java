/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Movie;
import entity.Theater;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author HP
 */
@Local
public interface MovieBeanLocal {
    
    void addMovie(Movie movie);
    //void addTheater(Theater theater);
    
    void deleteMovie(int movie_id);
    void deleteTheater(int id);
            
    Collection<Movie> getAllMovies();
    Collection<Theater> getAllTheater();
    
    void assignMovieToTheater(int mId, int tId);
    void deleteMovieFromheater(int mId, int tId);
}
