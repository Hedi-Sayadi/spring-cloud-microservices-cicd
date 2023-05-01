package P2M.moviecatatalogservice.models;

public class CatalogItem {
    private String name;
    private String desc ;
    private int rating ;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }
}
