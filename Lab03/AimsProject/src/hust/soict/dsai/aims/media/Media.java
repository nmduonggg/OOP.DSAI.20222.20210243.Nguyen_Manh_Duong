package hust.soict.dsai.aims.media;

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

    public boolean equals(Object o) {
        if (o instanceof Media) {
            Media m = (Media) o;
            return this.getTitle() == m.getTitle();
        } else {
            return false;
        }
    }
    
}
