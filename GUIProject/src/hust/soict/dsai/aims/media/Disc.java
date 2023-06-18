package hust.soict.dsai.aims.media;

public class Disc extends Media implements Playable {
    protected int length;
    protected String author;
    public int getLength() {
        return length;
    }
    public String getAuthor() {
        return author;
    }

    public String play(){
        return "";
    }

    public Disc (int id, String title) {
        super(id, title);
    }

    public Disc(String title) {
        super();
        this.title = title;
    }

    
}
