package hust.soict.dsai.aims.screen;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import hust.soict.dsai.aims.store.Store;
import java.util.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.Playable;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart = new Cart();
    
    // ***NORTH COMPONENT*** //
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout (FlowLayout.LEFT));

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;

    }

    // ***CENTER COMPONENT*** //
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;

    }

    // putting all together
    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
        Store store = new Store();
        
        for (int i = 1; i<=9; i++) {
            store.addMedia(new DigitalVideoDisc(i, "DVD"+i));
        }

        new StoreScreen(store);
    }
}

