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

    public Disc(int id, String title, String category, int length, String author, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.author = author;
}


    
}
