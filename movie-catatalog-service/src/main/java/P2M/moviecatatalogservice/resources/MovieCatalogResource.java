package P2M.moviecatatalogservice.resources;
import P2M.moviecatatalogservice.models.CatalogItem;
import P2M.moviecatatalogservice.models.Movie;
import P2M.moviecatatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired//this autowired is a consumer and the bean is a producer , with this annotation we inject the instance resttemplate created under the annotation Bean
    private RestTemplate restTemplate;
    /*@Autowired //the same thing now we will inject the webclient here
    private WebClient.Builder webClientBuilder ;*/

    @RequestMapping("/{userId}")
   @CircuitBreaker(name = "MovieCatalogService",fallbackMethod = "getFallbackCatalog")

//      @HystrixCommand(fallbackMethod = "getFallbackCatalog")//i want this method break the circuit when sth goes down and we add the getFallback method when the circuit breaks
    public List<CatalogItem> getCatalog (@PathVariable("userId") String userId){
       // RestTemplate restTemplate = new RestTemplate();//we are creating the restremplate inti the functio getcatalog , and it is badd because every time we run the function we create this instance and it's a waste .

        //suppose that this is the response we got from rating data api
        UserRating ratings= restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId, UserRating.class);

        //get all rated movie ids
        //for each movie id , call movie info service and get details
        //put them all together
        return  ratings.getRatings().stream().map(rating->{
           Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);// => we will do the equivalent of this with ewb client
                    /*Movie movie =webClientBuilder.build()
                            .get()//specify the method : get, post,...
                            .uri("http://localhost:8082/movies/" + rating.getMovieId())//specify the url
                            .retrieve()//go to fetch
                            .bodyToMono(Movie.class)//whatever the response is convert it into an instance of class Movie
                            .block();*/
            return new CatalogItem(movie.getName(),movie.getDescription(),rating.getRating());
        })
                .collect(Collectors.toList());

    }


    public List<CatalogItem> getFallbackCatalog(@PathVariable ("userId") String userId, Throwable t ){
        return Arrays.asList(new CatalogItem("No movie", "",0));
    }
}

