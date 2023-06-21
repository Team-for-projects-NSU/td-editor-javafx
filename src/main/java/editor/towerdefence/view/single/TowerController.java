package editor.towerdefence.view.single;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class TowerController {
    private int towersSize = 1;
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
        towerActionParam.setItems(FXCollections.observableArrayList("damage"));
        towerActionType.setItems(FXCollections.observableArrayList("Default", "Do nothing", "BasicAttack", "GenerateCurrency"));
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
        towerId.setText("ID :" + buttonId);
    }
    @FXML
    private void handleTowerImprovementButtonClick(ActionEvent event) {
    }
}
