package editor.towerdefence.view.single;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;

public class LevelController {
    private int levelSize = 1;
    private int waveSize = 0;

    @FXML
    private VBox levelIdsPanel;
    @FXML
    private VBox levelEditorPanel;
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
        VBox vbox = new VBox(8);
        vbox.setPadding(new Insets(4));

        Label waveId = new Label("Wave ID: " + waveSize);
        HBox enemyTypeHBox = new HBox(8);
        Label enemyTypeLabel = new Label("Enemy type:");
        TextField enemyTypeTextField = new TextField();
        enemyTypeHBox.getChildren().addAll(enemyTypeLabel, enemyTypeTextField);

        HBox enemyIntervalHBox = new HBox(8);
        Label enemyIntervalLabel = new Label("Enemy interval:");
        TextField enemyIntervalTextField = new TextField();
        enemyIntervalHBox.getChildren().addAll(enemyIntervalLabel, enemyIntervalTextField);

        HBox enemyAmountHBox = new HBox(8);
        Label enemyAmountLabel = new Label("Enemy amount:");
        TextField enemyAmountTextField = new TextField();
        enemyAmountHBox.getChildren().addAll(enemyAmountLabel, enemyAmountTextField);

        vbox.getChildren().addAll(waveId, enemyTypeHBox, enemyIntervalHBox, enemyAmountHBox);
        ObservableList<Node> children = levelEditorPanel.getChildren();
        int lastIndex = children.size() - 1;
        children.add(lastIndex, vbox);
        waveSize++;
    }
}