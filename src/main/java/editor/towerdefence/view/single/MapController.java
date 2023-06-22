package editor.towerdefence.view.single;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapController {
    private int mapsAmount = 1;
    private int currentId = 0;

    @FXML
    private Label mapId;
    @FXML
    private TextField mapX;
    @FXML
    private TextField mapY;
    @FXML
    private HBox mapIdsPanel;
    @FXML
    private TilePane map;

//    @FXML
//    private void initialize() {
//    }

    @FXML
    private void handleMapPlusButtonClick(ActionEvent event) {
        Button button = createMapButton(mapsAmount);
        mapIdsPanel.getChildren().add(mapsAmount, button);
        mapsAmount++;
    }

    @FXML
    private void handleMapIdButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonId = button.getText();
        mapId.setText("ID: " + buttonId);
        currentId = Integer.parseInt(buttonId);
    }

    @FXML
    private void handleMapGenerateButtonClick(ActionEvent event) {
        int rectangleSize = 20;
        int x;
        int y;
        try {
            x = Integer.parseInt(mapX.getText());
            y = Integer.parseInt(mapY.getText());
        } catch (Exception e) {
            x = 10;
            y = 10;
        }
        map.getChildren().clear();
        map.setPrefRows(y);
        map.setPrefColumns(x);
        map.setPrefTileHeight(20);
        map.setPrefTileWidth(20);
        map.setMaxWidth(20 * (x));
        map.setMaxHeight(20 * (y));
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Rectangle rectangle = new Rectangle(rectangleSize, rectangleSize);
                rectangle.setFill(Color.GREEN);
                rectangle.setStroke(Color.BLACK);
                rectangle.setOnMouseClicked(e -> rectangle.setFill(changeColor((Color) rectangle.getFill())));
                map.getChildren().add(rectangle);
            }
        }
    }

    private Color changeColor(Color color) {
        if (color == Color.GREEN) {
            return Color.YELLOW;
        }
        if (color == Color.YELLOW) {
            return Color.GRAY;
        }
        if (color == Color.GRAY) {
            return Color.BLUE;
        }
        if (color == Color.BLUE) {
            return Color.RED;
        }
        return Color.GREEN;
    }
    @FXML
    private void handleMapApplyButtonClick(ActionEvent event) {
    }


    private Button createMapButton(int id) {
        Button button = new Button(String.valueOf(id));
        button.setOnAction(this::handleMapIdButtonClick);
        return button;
    }
}