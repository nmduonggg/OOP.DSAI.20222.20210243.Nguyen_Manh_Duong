package hust.soict.dsai.aims.media;
import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }
    public boolean addAuthor(String authorName) {
        if (!(authors.contains(authorName))) {
            authors.add(authorName);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAuthod(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            return true;
        } else {
            return false;
        }
    }

}

