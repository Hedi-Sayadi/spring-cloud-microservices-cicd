package P2M.moviecatatalogservice.models;

public class Movie {
    private String movieId ;
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }
    public Movie(){

    }


    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
