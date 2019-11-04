package persistance.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies"
    ,catalog="cs4227"
)
public class Movies  implements java.io.Serializable {


     private Integer movieId;
     private String movieName;
     private String genre;
     private Set<Movielistings> movielistingses = new HashSet<Movielistings>(0);

    public Movies() {
    }

	
    public Movies(String movieName, String genre) {
        this.movieName = movieName;
        this.genre = genre;
    }
    public Movies(String movieName, String genre, Set<Movielistings> movielistingses) {
       this.movieName = movieName;
       this.genre = genre;
       this.movielistingses = movielistingses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="movieId", unique=true, nullable=false)
    public Integer getMovieId() {
        return this.movieId;
    }
    
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    
    @Column(name="movieName", nullable=false, length=15)
    public String getMovieName() {
        return this.movieName;
    }
    
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    
    @Column(name="genre", nullable=false, length=10)
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="movies")
    public Set<Movielistings> getMovielistingses() {
        return this.movielistingses;
    }
    
    public void setMovielistingses(Set<Movielistings> movielistingses) {
        this.movielistingses = movielistingses;
    }




}


