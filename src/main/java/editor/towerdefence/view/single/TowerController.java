package editor.towerdefence.view.single;

import editor.towerdefence.controller.TowerUpdater;
import editor.towerdefence.model.tower.Tower;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TowerController {
    private int towersSize = 1;
    private int currentId = 0;
    private TowerUpdater towerUpdater;
    private int improvementSize = 0;
    @FXML
    private VBox towerIdsPanel;
    @FXML
    private VBox towerEditorPanel;
    @FXML
    private Label towerId;
    @FXML
    private TextField towerName;
    @FXML
    private TextField towerHealth;
    @FXML
    private TextField towerCost;
    @FXML
    private TextField towerDemolitionCurrency;
    @FXML
    private TextField towerTexture;
    @FXML
    private TextField towerActionParamValue;
    @FXML
    private TextField towerActionRate;
    @FXML
    private TextField towerActionRange;
    @FXML
    private ComboBox<String> towerActionParam;
    @FXML
    private ComboBox<String> towerActionType;

    @FXML
    private void initialize() {
        towerUpdater = new TowerUpdater();
        towerActionParam.setItems(FXCollections.observableArrayList("damage"));
        towerActionType.setItems(FXCollections.observableArrayList("Default", "DoNothing", "BasicAttack", "GenerateCurrency"));
        changeText();
    }

    @FXML
    private void handlePlusButtonClick(ActionEvent event) {
        Button button = new Button("" + towersSize);
        button.setOnAction(this::handleTowerIdButtonClick);
        towerIdsPanel.getChildren().add(towersSize, button);
        towersSize++;
    }

    @FXML
    private void handleTowerIdButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonId = button.getText();
        towerId.setText("ID: " + buttonId);
        currentId = Integer.parseInt(buttonId);
        changeText();
    }

    @FXML
    private void handleTowerImprovementButtonClick(ActionEvent event) {
    }

    @FXML
    private void handleTowerApplyButtonClick(ActionEvent event) {
        towerUpdater.addChanges(currentId, towerName.getText(), towerHealth.getText(), towerCost.getText(),
                towerTexture.getText(), towerDemolitionCurrency.getText(), towerActionType.getValue(),
                towerActionRate.getText(), towerActionRange.getText(), towerActionParam.getValue(),
                towerActionParamValue.getText());
    }

    private void changeText() {
        Tower tower = towerUpdater.getTowerById(currentId);
        towerName.setText(tower.getName());
        towerHealth.setText(String.valueOf(tower.getMaxHealth()));
        towerCost.setText(String.valueOf(tower.getCost()));
        towerTexture.setText(tower.getSpriteName());
        towerDemolitionCurrency.setText(String.valueOf(tower.getDemolitionCurrency()));
        towerActionType.setValue(tower.getActionType().toString());
        towerActionRate.setText(String.valueOf(tower.getActionRate()));
        towerActionRange.setText(String.valueOf(tower.getActionRange()));
        String actionParameter = new ArrayList<>(tower.getActionParams().keySet()).get(0);
        towerActionParam.setValue(actionParameter);
        towerActionParamValue.setText(String.valueOf(tower.getActionParams().get(actionParameter)));
    }
}
