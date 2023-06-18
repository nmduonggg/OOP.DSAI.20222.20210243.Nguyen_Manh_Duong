package hust.soict.dsai.aims.screen;
import java.io.IOException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.JFrame;

import javafx.fxml.FXMLLoader;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = (Parent) loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main (String[] args){
        Cart cart = new Cart();
        for (int i = 1; i<=9; i++) {
            cart.addMedia(new DigitalVideoDisc(i, "DVD"+i));
        }

        new CartScreen(cart);
    }
}
