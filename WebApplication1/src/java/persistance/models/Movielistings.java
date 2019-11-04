package persistance.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="movielistings"
    ,catalog="cs4227"
)
public class Movielistings  implements java.io.Serializable {


     private Integer listId;
     private Movies movies;
     private Date date;
     private String time;

    public Movielistings() {
    }

    public Movielistings(Movies movies, String time) {
        this.movies = movies;
        this.time = time;
    }
    
    public Movielistings(Movies movies, Date date, String time) {
       this.movies = movies;
       this.date = date;
       this.time = time;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="listId", unique=true, nullable=false)
    public Integer getListId() {
        return this.listId;
    }
    
    public void setListId(Integer listId) {
        this.listId = listId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="movieId", nullable=false)
    public Movies getMovies() {
        return this.movies;
    }
    
    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    /**
     *
     * @return
     */
    @Temporal(TemporalType.DATE)
    @Column(name="date", length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    @Column(name="time", nullable=false, length=5)
    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }




}


