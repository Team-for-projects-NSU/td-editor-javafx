package editor.towerdefence.view.single;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class EntityController {
    @FXML
    private AnchorPane tower;
    @FXML
    private AnchorPane enemy;
    @FXML
    private AnchorPane level;
    @FXML
    private AnchorPane multilevel;

    @FXML
    private void initialize() {
        enemy.setVisible(false);
        level.setVisible(false);
        multilevel.setVisible(false);
        tower.setVisible(true);
    }

    @FXML
    private void handleTowerButtonClick(ActionEvent event) {
        level.setVisible(false);
        enemy.setVisible(false);
        multilevel.setVisible(false);
        tower.setVisible(true);
    }

    @FXML
    private void handleEnemyButtonClick(ActionEvent event) {
        level.setVisible(false);
        tower.setVisible(false);
        multilevel.setVisible(false);
        enemy.setVisible(true);
    }

    @FXML
    private void handleLevelButtonClick(ActionEvent event) {
        enemy.setVisible(false);
        tower.setVisible(false);
        multilevel.setVisible(false);
        level.setVisible(true);
    }
    @FXML
    private void handleMultiLevelButtonClick(ActionEvent event) {
        enemy.setVisible(false);
        tower.setVisible(false);
        level.setVisible(false);
        multilevel.setVisible(true);
    }
}
