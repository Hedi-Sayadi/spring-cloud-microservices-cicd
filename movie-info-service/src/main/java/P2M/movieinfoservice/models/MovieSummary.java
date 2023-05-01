package P2M.movieinfoservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

public class MovieSummary  {
    private String id ;
    private String Title ;
    private String overview ;

    public MovieSummary(String title, String overview) {
        Title = title;
        this.overview = overview;
    }
    public MovieSummary(){

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getOverview() {
        return overview;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

}
