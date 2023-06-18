package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public Track (String title, int length){
        this.title = title;
        this.length = length;
    }

    public String play () {
        return "Playing DVD: " + this.getTitle() + "\nDVD Length: " + this.getLength();
    }

    public boolean equals (Object o) {
        if (o instanceof Track) {
            Track t = (Track) o;
            return ((title == t.getTitle()) && (length == t.getLength()));
        } else {
            return false;
        }
        
    }
    
}