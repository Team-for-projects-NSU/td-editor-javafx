package editor.towerdefence.view.single;

import editor.towerdefence.controller.MainUpdater;
import editor.towerdefence.model.tower.Tower;
import editor.towerdefence.model.tower.TowerUpgrade;
import editor.towerdefence.model.tower.Upgrade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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
    private VBox improvements;
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
        towerActionParam.setItems(FXCollections.observableArrayList("damage", "value"));
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
        Label costLabel = new Label("Cost:");
        Label maxHealthLabel = new Label("Max health:");
        Label demolitionCurrencyLabel = new Label("Demolition currency:");
        Label actionRateLabel = new Label("Action rate:");
        Label actionRangeLabel = new Label("Action range:");
        Label damageLabel = new Label("Damage:");
        Label valueLabel = new Label("Value:");
        TextField costTextField = new TextField();
        TextField maxHealthTextField = new TextField();
        TextField demolitionCurrencyTextField = new TextField();
        TextField actionRateTextField = new TextField();
        TextField actionRangeTextField = new TextField();
        TextField damageTextField = new TextField();
        TextField valueTextField = new TextField();
        HBox costHBox = new HBox(8, costLabel, costTextField);
        HBox maxHealthHBox = new HBox(8, maxHealthLabel, maxHealthTextField);
        HBox demolitionCurrencyHBox = new HBox(8, demolitionCurrencyLabel, demolitionCurrencyTextField);
        HBox actionRateHBox = new HBox(8, actionRateLabel, actionRateTextField);
        HBox actionRangeHBox = new HBox(8, actionRangeLabel, actionRangeTextField);
        HBox damageHBox = new HBox(8, damageLabel, damageTextField);
        HBox valueHBox = new HBox(8, valueLabel, valueTextField);
        VBox vBox = new VBox(8);
        Label modifier = new Label("Modifiers");
        vBox.getChildren().addAll(costHBox, modifier, maxHealthHBox, demolitionCurrencyHBox, actionRateHBox, actionRangeHBox, damageHBox, valueHBox);
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.getChildren().add(vBox);
        improvements.getChildren().add(hBox);
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
        ObservableList<Node> improvementsChildren = improvements.getChildren();
        List<TowerUpgrade> list = new ArrayList<>();
        for (Node child : improvementsChildren) {
            if (child instanceof HBox) {
                HBox hboxBig = (HBox) child;
                ObservableList<Node> hboxBigChildren = hboxBig.getChildren();
                for (Node vboxChild : hboxBigChildren) {
                    if (vboxChild instanceof VBox) {
                        TowerUpgrade towerUpgrade = new TowerUpgrade();
                        VBox vbox = (VBox) vboxChild;
                        ObservableList<Node> vboxChildren = vbox.getChildren();

                        for (Node hboxChild : vboxChildren) {
                            if (hboxChild instanceof HBox) {
                                HBox innerHBox = (HBox) hboxChild;
                                Label innerLabel = (Label) innerHBox.getChildren().get(0);
                                TextField innerTextField = (TextField) innerHBox.getChildren().get(1);
                                String labelText = innerLabel.getText();
                                String textFieldText = innerTextField.getText();
                                switch (labelText) {
                                    case "Cost:":
                                        int price = Integer.parseInt(textFieldText);
                                        towerUpgrade.setPrice(price);
                                        break;
                                    case "Max health:":
                                        float maxHealthModifier = Float.parseFloat(textFieldText);
                                        Upgrade maxHealthUpgrade = new Upgrade("maxHealth", maxHealthModifier);
                                        towerUpgrade.getModifiers().add(maxHealthUpgrade);
                                        break;
                                    case "Demolition currency:":
                                        float demolitionCurrencyModifier = Float.parseFloat(textFieldText);
                                        Upgrade demolitionCurrencyUpgrade = new Upgrade("demolitionCurrency", demolitionCurrencyModifier);
                                        towerUpgrade.getModifiers().add(demolitionCurrencyUpgrade);
                                        break;
                                    case "Action rate:":
                                        float actionRateModifier = Float.parseFloat(textFieldText);
                                        Upgrade actionRateUpgrade = new Upgrade("actionRate", actionRateModifier);
                                        towerUpgrade.getModifiers().add(actionRateUpgrade);
                                        break;
                                    case "Action range:":
                                        float actionRangeModifier = Float.parseFloat(textFieldText);
                                        Upgrade actionRangeUpgrade = new Upgrade("actionRange", actionRangeModifier);
                                        towerUpgrade.getModifiers().add(actionRangeUpgrade);
                                        break;
                                    case "Damage:":
                                        float damageModifier = Float.parseFloat(textFieldText);
                                        Upgrade damageUpgrade = new Upgrade("damage", damageModifier);
                                        towerUpgrade.getModifiers().add(damageUpgrade);
                                        break;
                                    case "Value:":
//                                        float valueModifier = Float.parseFloat(textFieldText);
//                                        Upgrade valueUpgrade = new Upgrade("value", valueModifier);
//                                        towerUpgrade.getModifiers().add(valueUpgrade);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        list.add(towerUpgrade);
                    }
                }
            }
        }
//        for (Node child : improvementsChildren) {
//            if (child instanceof VBox) {
//                VBox vbox = (VBox) child;
//                ObservableList<Node> vboxChildren = vbox.getChildren();
//                TowerUpgrade towerUpgrade = new TowerUpgrade();
//                for (Node vboxChild : vboxChildren) {
//                    if (vboxChild instanceof HBox) {
//                        HBox hbox = (HBox) vboxChild;
//                        ObservableList<Node> hboxChildren = hbox.getChildren();
//
//                        if (hboxChildren.size() == 2) {
//                            Node labelNode = hboxChildren.get(0);
//                            Node textFieldNode = hboxChildren.get(1);
//
//                            if (labelNode instanceof Label && textFieldNode instanceof TextField) {
//                                Label label = (Label) labelNode;
//                                TextField textField = (TextField) textFieldNode;
//                                String labelText = label.getText();
//                                String textFieldText = textField.getText();
//
//                                switch (labelText) {
//                                    case "Cost:":
//                                        int price = Integer.parseInt(textFieldText);
//                                        towerUpgrade.setPrice(price);
//                                        break;
//                                    case "Max health:":
//                                        float maxHealthModifier = Float.parseFloat(textFieldText);
//                                        Upgrade maxHealthUpgrade = new Upgrade("maxHealth", maxHealthModifier);
//                                        towerUpgrade.getModifiers().add(maxHealthUpgrade);
//                                        break;
//                                    case "Demolition currency:":
//                                        float demolitionCurrencyModifier = Float.parseFloat(textFieldText);
//                                        Upgrade demolitionCurrencyUpgrade = new Upgrade("demolitionCurrency", demolitionCurrencyModifier);
//                                        towerUpgrade.getModifiers().add(demolitionCurrencyUpgrade);
//                                        break;
//                                    case "Action rate:":
//                                        float actionRateModifier = Float.parseFloat(textFieldText);
//                                        Upgrade actionRateUpgrade = new Upgrade("actionRate", actionRateModifier);
//                                        towerUpgrade.getModifiers().add(actionRateUpgrade);
//                                        break;
//                                    case "Action range:":
//                                        float actionRangeModifier = Float.parseFloat(textFieldText);
//                                        Upgrade actionRangeUpgrade = new Upgrade("actionRange", actionRangeModifier);
//                                        towerUpgrade.getModifiers().add(actionRangeUpgrade);
//                                        break;
//                                    case "Damage:":
//                                        float damageModifier = Float.parseFloat(textFieldText);
//                                        Upgrade damageUpgrade = new Upgrade("damage", damageModifier);
//                                        towerUpgrade.getModifiers().add(damageUpgrade);
//                                        break;
//                                    case "Value:":
//                                        float valueModifier = Float.parseFloat(textFieldText);
//                                        Upgrade valueUpgrade = new Upgrade("value", valueModifier);
//                                        towerUpgrade.getModifiers().add(valueUpgrade);
//                                        break;
//                                    default:
//                                        break;
//                                }
//                            }
//                        }
//                    }
//                }
//
//                list.add(towerUpgrade);
//            }
//        }
        MainUpdater.getInstance().getTowerUpdater().addChanges(currentId, towerName.getText(), towerHealth.getText(),
                towerCost.getText(), towerTexture.getText(), towerDemolitionCurrency.getText(), towerActionType.getValue(),
                towerActionRate.getText(), towerActionRange.getText(), actionParamList, list);
    }

    @FXML
    private void handleAddActionParamButtonClick(ActionEvent event) {
        HBox hbox = new HBox();
        hbox.setSpacing(8.0);
        Label label = new Label("Action parameter:");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPrefWidth(150.0);
        comboBox.setItems(FXCollections.observableArrayList("damage", "value"));
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
            comboBox.setItems(FXCollections.observableArrayList("damage", "value"));
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