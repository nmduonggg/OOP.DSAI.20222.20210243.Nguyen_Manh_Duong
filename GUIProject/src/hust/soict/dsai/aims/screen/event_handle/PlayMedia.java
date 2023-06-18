package hust.soict.dsai.aims.screen.event_handle;
import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.media.*;

public class PlayMedia extends JDialog {
        public PlayMedia (Playable disc) {
            super();
            Container cp = getContentPane();
            cp.setLayout(new FlowLayout(FlowLayout.CENTER));
            cp.add(new JLabel(disc.play()));

            setTitle("Playing");
            setSize(300, 100);
            setVisible(true);
        }
    }