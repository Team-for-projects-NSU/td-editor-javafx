package editor.towerdefence.view.single;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LevelController {
    private int levelSize = 1;

    @FXML
    private VBox levelIdsPanel;
    @FXML
    private Label levelId;
    @FXML
    private TextField levelTimeWaves;
    @FXML
    private TextField levelInitMoney;
    @FXML
    private TextField levelReward;
    @FXML
    private TextField levelMap;
    @FXML
    private TextField levelEnemySpeed;
    @FXML
    private TextField levelEnemyDamage;
    @FXML
    private TextField levelEnemyHealth;

    @FXML
    private void handleLevelPlusButtonClick(ActionEvent event) {
        Button button = new Button("" + levelSize);
        button.setOnAction(this::handleLevelIdButtonClick);
        levelIdsPanel.getChildren().add(levelSize, button);
        levelSize++;
    }

    @FXML
    private void handleLevelIdButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonId = button.getText();
        levelId.setText("ID: " + buttonId);
    }

    @FXML
    private void handleLevelAddWaveButtonClick(ActionEvent event) {
    }
}