package P2M.ratingsdataservice.resources;

import P2M.ratingsdataservice.models.Rating;
import P2M.ratingsdataservice.models.UserRating;
import P2M.ratingsdataservice.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class MovieDataResource {
    private final RatingService ratingService ;
    public MovieDataResource (RatingService ratingservice) {
        this.ratingService = ratingservice;
    }
    private Rating myRating ;

    public List<Rating> getAllRatingsForUser(@PathVariable String userId) {
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
            return ratings;

    }
    @PostMapping("/addrating")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        Rating newRating = ratingService.addRating(rating);
        return new ResponseEntity<>(newRating, HttpStatus.CREATED);
    }
    @GetMapping("/find/{movieId}")
    public Rating getRatingById(@PathVariable("movieId") String movieId) {
        myRating = ratingService.findRatingByMovieId(movieId);
        return myRating;
    }

    @RequestMapping("/{movieId}")
    public Rating getRating (@PathVariable ("movieId") String movieId){
        Rating currentRating = this.getRatingById(movieId);
        return currentRating;
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable ("userId") String userId){
//           List<Rating> myratings = this.getAllRatings().getBody();
//           List<Rating> ratings = myratings;
//        Arrays.asList(
//                new Rating("100",2),
//                new Rating("550",4)
//        );
        List<Rating> current = this.getAllRatingsForUser(userId);

        UserRating userRating = new UserRating();
        userRating.setRatings(current);
        userRating.setUserId(userId);
        return userRating ;
    }
//    @RequestMapping("/users/{userId}")
//    public ResponseEntity<List<Rating>> getUserRating2(@PathVariable ("userId") String userId){
//        List<Rating> current = this.getAllRatingsForUser(userId);
//        if (current.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(current);
//        }
//        return current ;
//     }



}
