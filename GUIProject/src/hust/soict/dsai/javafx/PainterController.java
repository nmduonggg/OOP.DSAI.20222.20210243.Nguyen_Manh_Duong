package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;

public class PainterController {
    @FXML private Pane drawingAreaPane;
    @FXML private RadioButton penRadioButton;
    @FXML private RadioButton eraserRadioButton;
    @FXML private TitledPane ToolsPane;
    @FXML private ToggleGroup tools;
    @FXML private Paint color = Color.BLACK;

    @FXML
    public void intitialize() {
        penRadioButton.setToggleGroup(tools);
        eraserRadioButton.setToggleGroup(tools);;
        // penRadioButton.setUserData(Color.BLACK);
        // eraserRadioButton.setUserData(Color.WHITE);
    }
    
    @FXML
    void chooseToolPressed(ActionEvent e) {
        if (penRadioButton.isSelected()) {
            color = Color.BLACK;
        } else if (eraserRadioButton.isSelected()) {
            color = Color.WHITE;
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    
}
