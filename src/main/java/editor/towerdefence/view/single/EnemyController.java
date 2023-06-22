package editor.towerdefence.view.single;

import editor.towerdefence.controller.EnemyUpdater;
import editor.towerdefence.controller.MainUpdater;
import editor.towerdefence.model.enemy.Enemy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class EnemyController {
    private int enemiesSize = 1;
    private int currentId = 0;
    @FXML
    private VBox enemyIdsPanel;
    @FXML
    private Label enemyId;
    @FXML
    private TextField enemyName;
    @FXML
    private TextField enemyHealth;
    @FXML
    private TextField enemyTexture;
    @FXML
    private ComboBox<String> enemyActionParam;
    @FXML
    private TextField enemyActionParamValue;
    @FXML
    private ComboBox<String> enemyActionType;
    @FXML
    private TextField enemyActionRate;
    @FXML
    private TextField enemyActionRange;
    @FXML
    private TextField enemyReward;
    @FXML
    private TextField enemySpeed;

    @FXML
    private void initialize() {
        enemyActionParam.getItems().addAll("damage");
        enemyActionType.getItems().addAll("Default", "Do nothing", "BasicAttack");
        changeText();
    }

    @FXML
    private void handleEnemyPlusButtonClick(ActionEvent event) {
        Button button = new Button("" + enemiesSize);
        button.setOnAction(this::handleEnemyIdButtonClick);
        enemyIdsPanel.getChildren().add(enemiesSize, button);
        enemiesSize++;
    }

    @FXML
    private void handleEnemyIdButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonId = button.getText();
        enemyId.setText("ID: " + buttonId);
        currentId = Integer.parseInt(buttonId);
        changeText();
    }

    @FXML
    private void handleEnemyApplyButtonClick(ActionEvent event) {
        MainUpdater.getInstance().getEnemyUpdater().addChanges(currentId, enemyName.getText(), enemyHealth.getText(), enemyReward.getText(),
                enemyTexture.getText(), enemySpeed.getText(), enemyActionType.getValue(),
                enemyActionRate.getText(), enemyActionRange.getText(), enemyActionParam.getValue(),
                enemyActionParamValue.getText());
    }

    private void changeText() {
        Enemy enemy = MainUpdater.getInstance().getEnemyUpdater().getEnemyById(currentId);
        enemyName.setText(enemy.getName());
        enemyHealth.setText(String.valueOf(enemy.getMaxHealth()));
        enemyReward.setText(String.valueOf(enemy.getReward()));
        enemyTexture.setText(enemy.getSpriteFileName());
        enemySpeed.setText(String.valueOf(enemy.getSpeed()));
        enemyActionType.setValue(enemy.getActionType().toString());
        enemyActionRate.setText(String.valueOf(enemy.getActionRate()));
        enemyActionRange.setText(String.valueOf(enemy.getActionRange()));
        String actionParameter = new ArrayList<>(enemy.getActionParameters().keySet()).get(0);
        enemyActionParam.setValue(actionParameter);
        enemyActionParamValue.setText(String.valueOf(enemy.getActionParameters().get(actionParameter)));
    }
}
