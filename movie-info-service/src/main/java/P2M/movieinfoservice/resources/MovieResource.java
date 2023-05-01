package P2M.movieinfoservice.resources;

import P2M.movieinfoservice.models.Movie;
import P2M.movieinfoservice.models.MovieSummary;
import P2M.movieinfoservice.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    private final MovieInfoService  movieInfoService ;
    public MovieResource (MovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
        Movie newMovie = new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
        Movie addedMovie = movieInfoService.addMovie(newMovie);
        return newMovie;
//        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }



}
