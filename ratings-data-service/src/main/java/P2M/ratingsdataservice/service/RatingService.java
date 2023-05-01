package P2M.ratingsdataservice.service;

import P2M.ratingsdataservice.exception.RatingNotFoundException;
import P2M.ratingsdataservice.models.Rating;
import P2M.ratingsdataservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepo;
    @Autowired
    public RatingService(RatingRepository ratingRepo){
        this.ratingRepo = ratingRepo ;
    }
    public Rating addRating (Rating rating ){
        return ratingRepo.save(rating);
    }
    public List<Rating> findAllRating(){
        return ratingRepo.findAll();
    }
    public Rating findRatingByMovieId (String movieId){
        return ratingRepo.findById(movieId).orElseThrow(() -> new RatingNotFoundException("Rating By movieid not found"));
    }
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepo.findAllByUserId(userId);
    }
//    public List<Rating> getAllRatingsForUser (String userId){
//        return ratingRepo.findAllByUserId(userId);
//    }

}
