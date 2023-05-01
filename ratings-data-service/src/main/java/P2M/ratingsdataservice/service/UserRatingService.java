//package P2M.ratingsdataservice.service;
//
//import P2M.ratingsdataservice.models.Rating;
//import P2M.ratingsdataservice.models.UserRating;
//import P2M.ratingsdataservice.repository.RatingRepository;
//import P2M.ratingsdataservice.repository.UserRatingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserRatingService {
//    private final UserRatingRepository userRatingRepo;
//    @Autowired
//    public UserRatingService(UserRatingRepository userRatingRepo){
//        this.userRatingRepo = userRatingRepo ;
//    }
//    public UserRating addUserRating (UserRating userRating){
//        return userRatingRepo.save(userRating);
//    }
//    public List<UserRating> findAllUserRating(){
//        return userRatingRepo.findAll();
//    }
//}
