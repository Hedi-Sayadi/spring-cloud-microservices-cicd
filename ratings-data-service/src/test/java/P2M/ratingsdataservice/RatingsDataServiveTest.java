package P2M.ratingsdataservice;

import P2M.ratingsdataservice.models.Rating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RatingsDataServiveTest {
private Rating rating ;
    @BeforeEach
    void init(){
        rating = new Rating ("200",3,"hedi");

    }
    @Test
    void testMovieId() {
        assertNotNull(rating);
        assertEquals("200", rating.getMovieId());
        rating.setMovieId("300");
        assertEquals("300", rating.getMovieId());
    }
    @Test
    void testRating() {
        assertNotNull(rating);
        assertEquals(3, rating.getRating());
        rating.setRating(3);
        assertEquals(3, rating.getRating());
    }

}
