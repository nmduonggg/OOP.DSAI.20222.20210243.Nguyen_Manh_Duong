package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    public boolean addMedia(Media m){
        if (!(itemsInStore.contains(m))) {
            itemsInStore.add(m);
            return true;
        } else{
            return false;
        }
    }

    public boolean removeMedia(Media m) {
        if (itemsInStore.contains(m)) {
            itemsInStore.remove(m);
            return true;
        } else {
            return false;
        }
    }

    public Store(){
        super();
    }
}
