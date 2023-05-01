package P2M.moviecatatalogservice.models;

public class Rating {
    private String movieId ;
    private int Rating ;

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        Rating = rating;
    }
    public Rating(){

    }

    public String getMovieId() {
        return movieId;
    }

    public int getRating() {
        return Rating;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}
