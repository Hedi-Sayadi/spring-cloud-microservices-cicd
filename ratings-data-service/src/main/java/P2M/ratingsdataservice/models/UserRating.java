package P2M.ratingsdataservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

//we create this class just to be able to pass the type in the parameter of the restTemplate.getForObject(url,UserRating)
//@Entity
public class UserRating implements Serializable {
//    @Id
    private String UserId;
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Rating> ratings ;

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
    public UserRating(){

    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getUserId() {
        return UserId;
    }

    public UserRating(String userId, List<Rating> ratings) {
        UserId = userId;
        this.ratings = ratings;
    }

}

