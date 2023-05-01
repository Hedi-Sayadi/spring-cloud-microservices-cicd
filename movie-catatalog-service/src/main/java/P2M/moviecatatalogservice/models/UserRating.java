package P2M.moviecatatalogservice.models;

import java.util.List;

//we create this class just to be able to pass the type in the parameter of the restTemplate.getForObject(url,UserRating)
public class UserRating {
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
}
