package P2M.ratingsdataservice.repository;

import P2M.ratingsdataservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RatingRepository extends JpaRepository <Rating,String> {

//    Optional<Rating> findByMovieId(String movieId);
    @Query(value = "SELECT * FROM rating WHERE user_id = :userId", nativeQuery = true)
    List<Rating> findAllByUserId(String userId);
}
