//package P2M.ratingsdataservice.resources;
//
//import P2M.ratingsdataservice.models.Rating;
//import P2M.ratingsdataservice.models.UserRating;
//import P2M.ratingsdataservice.service.RatingService;
//import P2M.ratingsdataservice.service.UserRatingService;
//import org.apache.catalina.User;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/userratingsdata")
//public class UserRatingRessource {
//    private List<UserRating> userRatings ;
//    private final UserRatingService userRatingService ;
//    public UserRatingRessource (UserRatingService userRatingService) {
//        this.userRatingService = userRatingService;
//    }
//
//    @PostMapping("/adduserrating")
//    public ResponseEntity<UserRating> addRating(@RequestBody UserRating userRating){
//        UserRating newUserRating = userRatingService.addUserRating(userRating);
//        return new ResponseEntity<>(newUserRating, HttpStatus.CREATED);
//    }
//    @GetMapping("/all")
//    public List<UserRating> getUserRatings (){
//        userRatings= userRatingService.findAllUserRating();
//        return userRatings;
//    }
//
//}
