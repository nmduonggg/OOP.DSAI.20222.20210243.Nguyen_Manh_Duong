package hust.soict.dsai.aims.media;
import java.util.*;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
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
    
}
