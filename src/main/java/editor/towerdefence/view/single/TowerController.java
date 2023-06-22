package editor.towerdefence.view.single;

import editor.towerdefence.controller.MainUpdater;
import editor.towerdefence.model.tower.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TowerController {
    private int towersSize = 1;
    private int currentId = 0;
    private int improvementSize = 0;
    @FXML
    private VBox towerIdsPanel;
    @FXML
    private VBox towerEditorPanel;
    @FXML
    private VBox actionParamContainer;
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
        MainUpdater.getInstance().getTowerUpdater().addChanges(currentId, towerName.getText(), towerHealth.getText(), towerCost.getText(),
                towerTexture.getText(), towerDemolitionCurrency.getText(), towerActionType.getValue(),
                towerActionRate.getText(), towerActionRange.getText(), actionParamList);
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
    private void changeText() {
        Tower tower = MainUpdater.getInstance().getTowerUpdater().getTowerById(currentId);
        towerName.setText(tower.getName());
        towerHealth.setText(String.valueOf(tower.getMaxHealth()));
        towerCost.setText(String.valueOf(tower.getCost()));
        towerTexture.setText(tower.getSpriteName());
        towerDemolitionCurrency.setText(String.valueOf(tower.getDemolitionCurrency()));
        towerActionType.setValue(tower.getActionType().toString());
        towerActionRate.setText(String.valueOf(tower.getActionRate()));
        towerActionRange.setText(String.valueOf(tower.getActionRange()));
        Map<String, Float> actionParams = tower.getActionParams();
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
//        String actionParameter = new ArrayList<>(tower.getActionParams().keySet()).get(0);
//        towerActionParam.setValue(actionParameter);
//        towerActionParamValue.setText(String.valueOf(tower.getActionParams().get(actionParameter)));
    }
}
