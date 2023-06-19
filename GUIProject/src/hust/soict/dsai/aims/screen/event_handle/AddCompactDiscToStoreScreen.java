package hust.soict.dsai.aims.screen.event_handle;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStore {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "DVD");

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/addCD.fxml"));
                    AddCompactDiscToScreenController controller = new AddCompactDiscToScreenController(store);
                    loader.setController(controller);
                    Parent root = (Parent) loader.load();
                    fxPanel.setScene (new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setSize(640, 480);
    }

    private class AddCompactDiscToScreenController {

        @FXML private TextField titleCD;
        @FXML private TextField authorCD;
        @FXML private TextField categoryCD;
        @FXML private TextField costCD;
        @FXML private TextField lengthCD;
        @FXML private Button btnAddCD;


        public AddCompactDiscToScreenController(Store _store) {
            super();
            store = _store;
        }

        @FXML
        private void intitialize() {
            btnAddCD.setVisible(true);
            titleCD.setVisible(true);
            authorCD.setVisible(true);
            categoryCD.setVisible(true);
            costCD.setVisible(true);
            lengthCD.setVisible(true);

        }

        @FXML
        private void btnAddCDPressed() {
            String title = titleCD.getText();
            String author = authorCD.getText();
            String category = categoryCD.getText();
            Float cost = Float.parseFloat(costCD.getText());
            Integer length = Integer.parseInt(lengthCD.getText());
            store.addMedia(new CompactDisc(1, title, category, length , author, cost));
        }
    }
}