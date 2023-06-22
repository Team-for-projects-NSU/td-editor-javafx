package editor.towerdefence.view.single;

import editor.towerdefence.controller.EnemyUpdater;
import editor.towerdefence.controller.MainUpdater;
import editor.towerdefence.model.enemy.Enemy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnemyController {
    private int enemiesSize = 1;
    private int currentId = 0;
    @FXML
    private VBox enemyIdsPanel;
    @FXML
    private VBox actionParamContainer;
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
    private void handleAddActionParamButtonClick(ActionEvent event) {
        HBox hbox = new HBox();
        hbox.setSpacing(8.0);
        Label label = new Label("Action parameter:");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPrefWidth(150.0);
        comboBox.setItems(FXCollections.observableArrayList("damage"));
        TextField textField = new TextField();
        textField.setPromptText("value");
        hbox.getChildren().addAll(label, comboBox, textField);
        actionParamContainer.getChildren().add(hbox);
    }

    @FXML
    private void handleEnemyApplyButtonClick(ActionEvent event) {
        List<Pair<String, String>> actionParamList = new ArrayList<>();
        ObservableList<Node> children = actionParamContainer.getChildren();
        for (Node child : children) {
            if (child instanceof HBox) {
                HBox hbox = (HBox) child;
                ComboBox<String> comboBox = (ComboBox<String>) hbox.getChildren().get(1);
                TextField textField = (TextField) hbox.getChildren().get(2);
                String actionParam = comboBox.getValue();
                String actionParamValue = textField.getText();
                actionParamList.add(new Pair<>(actionParam, actionParamValue));
            }
        }
        MainUpdater.getInstance().getEnemyUpdater().addChanges(currentId, enemyName.getText(), enemyHealth.getText(), enemyReward.getText(),
                enemyTexture.getText(), enemySpeed.getText(), enemyActionType.getValue(),
                enemyActionRate.getText(), enemyActionRange.getText(), actionParamList);
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
        Map<String, Float> actionParams = enemy.getActionParameters();
        actionParamContainer.getChildren().clear();
        for (Map.Entry<String, Float> entry : actionParams.entrySet()) {
            String actionParam = entry.getKey();
            Float actionParamValue = entry.getValue();
            HBox hbox = new HBox();
            hbox.setSpacing(8.0);
            Label label = new Label("Action parameter:");
            ComboBox<String> comboBox = new ComboBox<>();
            comboBox.setPrefWidth(150.0);
            comboBox.setItems(FXCollections.observableArrayList("damage"));
            comboBox.setValue(actionParam);
            TextField textField = new TextField();
            textField.setPromptText("value");
            textField.setText(String.valueOf(actionParamValue));
            hbox.getChildren().addAll(label, comboBox, textField);
            actionParamContainer.getChildren().add(hbox);
        }
//        String actionParameter = new ArrayList<>(enemy.getActionParameters().keySet()).get(0);
//        enemyActionParam.setValue(actionParameter);
//        enemyActionParamValue.setText(String.valueOf(enemy.getActionParameters().get(actionParameter)));
    }
}
