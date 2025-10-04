/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Collection;


/**
 *
 * @author HP
 */
@Entity
@Table
public class Theater  {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    
    private String name;
    private String city;
    private String state;
    private String location;
    
    
    @ManyToMany()
    @JoinTable(joinColumns = {
        @JoinColumn(name = "TheaterId", referencedColumnName = "id")
    },
            inverseJoinColumns = {
                @JoinColumn(name = "MovieId", referencedColumnName = "movie_id")
            },
            name = "theater_movie"
    )
    private Collection<Movie> movies;

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
}
