package hust.soict.dsai.aims.screen.event_handle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hust.soict.dsai.aims.store.Store;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.awt.*;

public class AddItemToStore extends JFrame {
    protected Store store;
    protected String type;

    public AddItemToStore (Store store, String mediaType) {
        super();

        // Container cp = getContentPane();
        // cp.setLayout(new FlowLayout(FlowLayout.CENTER));
        // cp.add(new JLabel("Add " + mediaType + " to store successfully"));

        // setTitle("Added to store");
        // setSize(300, 100);
        // setVisible(true);

        this.store = store;
        this.type = mediaType;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public Store getUpdatedStore(Media media) {
        this.store.addMedia(media);
        return store;
    }

}
