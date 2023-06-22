package editor.towerdefence.view.single;

import editor.towerdefence.controller.MainUpdater;
import editor.towerdefence.model.tower.TowerUpgrade;
import editor.towerdefence.model.tower.Upgrade;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class LevelController {
    private int levelSize = 1;
    private int waveSize = 0;
    private int currentId = 0;

    @FXML
    private VBox levelIdsPanel;
    @FXML
    private VBox levelEditorPanel;
    @FXML
    private VBox waves;
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
    private TextField roadTexture;
    @FXML
    private TextField backgroundTexture;
    @FXML
    private TextField plotTexture;

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
        currentId = Integer.parseInt(buttonId);
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
        waves.getChildren().add(vbox);
//        ObservableList<Node> children = levelEditorPanel.getChildren();
//        int lastIndex = children.size() - 1;
//        children.add(lastIndex, vbox);
        waveSize++;
    }

    @FXML
    private void handleTowerApplyButtonClick(ActionEvent event) {
        List<WaveRecord> wavesList = new ArrayList<>();
        for (Node node : waves.getChildren()) {
            if (node instanceof VBox) {
                VBox vbox = (VBox) node;
                WaveRecord waveRecord = new WaveRecord();
                ObservableList<Node> vboxChildren = vbox.getChildren();
                for (Node vboxChild : vboxChildren) {
                    if (vboxChild instanceof HBox) {
                        HBox hbox = (HBox) vboxChild;
                        ObservableList<Node> hboxChildren = hbox.getChildren();
                        if (hboxChildren.size() == 2) {
                            Node labelNode = hboxChildren.get(0);
                            Node textFieldNode = hboxChildren.get(1);

                            if (labelNode instanceof Label && textFieldNode instanceof TextField) {
                                Label label = (Label) labelNode;
                                TextField textField = (TextField) textFieldNode;
                                String labelText = label.getText();
                                String textFieldText = textField.getText();

                                switch (labelText) {
                                    case "Enemy type:":
                                        waveRecord.enemyTypes = textFieldText;
                                        break;
                                    case "Enemy interval:":
                                        waveRecord.enemyInterval=textFieldText;
                                        break;
                                    case "Enemy amount:":
                                        waveRecord.enemyAmount = textFieldText;
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                }

                wavesList.add(waveRecord);
            }
        }
        MainUpdater.getInstance().getLevelUpdater().addChanges(currentId, levelTimeWaves.getText(), levelInitMoney.getText(),
                levelReward.getText(), backgroundTexture.getText(), plotTexture.getText(), roadTexture.getText(), wavesList,levelMap.getText());
    }
}