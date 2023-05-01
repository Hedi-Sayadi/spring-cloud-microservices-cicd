package P2M.movieinfoservice.service;

import P2M.movieinfoservice.models.Movie;
import P2M.movieinfoservice.models.MovieSummary;
import P2M.movieinfoservice.repository.MovieInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieInfoService {
 private final MovieInfoRepo movieinfoRepo ;
    @Autowired
    public MovieInfoService(MovieInfoRepo movieinfoRepo){
        this.movieinfoRepo = movieinfoRepo ;
    }
    public List<Movie> findAllMovie(){
        return movieinfoRepo.findAll();
    }
    public Movie addMovie (Movie movie ){
        return movieinfoRepo.save(movie);
    }



}
