package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    public String toString() {
        return "Id: " + id + ", Title: " + title + ", Category: " + category + ", Cost: " + cost;
    }

    public boolean equals(Object o) {
        if (o instanceof Media) {
            Media m = (Media) o;
            return this.getTitle().equals(m.getTitle());
        } else {
            return false;
        }
    }

    public Media(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public Media(){

    }

}
