package P2M.movieinfoservice.repository;

import P2M.movieinfoservice.models.Movie;
import P2M.movieinfoservice.models.MovieSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieInfoRepo extends JpaRepository <Movie, String > {

}
