package P2M.ratingsdataservice.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {
    @Id
    private String movieId ;
    private int Rating ;
    private String UserId ;

    public Rating(String movieId, int rating, String userId) {
        this.movieId = movieId;
        Rating = rating;
        UserId = userId;
    }

    public Rating() {

    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getRating() {
        return Rating;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
//    @ManyToOne
//    @JoinColumn(name="userId")
//    public UserRating userRating ; //on met
}
