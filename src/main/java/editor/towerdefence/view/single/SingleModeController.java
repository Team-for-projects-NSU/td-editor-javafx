package editor.towerdefence.view.single;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SingleModeController {
    @FXML
    private AnchorPane entity;
    @FXML
    private AnchorPane map;
    @FXML
    private AnchorPane technoTree;

    @FXML
    private void initialize() {
        map.setVisible(false);
//        technoTree.setVisible(false);
        entity.setVisible(true);
    }
    @FXML
    private void handleEntityButtonClick(ActionEvent event) {
        map.setVisible(false);
//        technoTree.setVisible(false);
        entity.setVisible(true);
    }

    @FXML
    private void handleMapButtonClick(ActionEvent event) {
        entity.setVisible(false);
//        technoTree.setVisible(false);
        map.setVisible(true);
    }

    @FXML
    private void handleTechnoTreeButtonClick(ActionEvent event) {
        entity.setVisible(false);
        map.setVisible(false);
        technoTree.setVisible(true);
    }

}
