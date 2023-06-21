package editor.towerdefence.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {
    @FXML
    private HBox mainButtons;
    @FXML
    private AnchorPane single;
    @FXML
    private void initialize(){
        single.setVisible(false);
        mainButtons.setVisible(true);
    }
    @FXML
    private void switchToSingle(ActionEvent event) throws IOException {
        mainButtons.setVisible(false);
        single.setVisible(true);
    }
}
