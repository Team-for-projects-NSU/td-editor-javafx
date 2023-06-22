package editor.towerdefence.view.single;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TreeController {
    private int size = 0;
    @FXML
    private VBox treeNodes;

    @FXML
    private void handleAddNodeButtonClick(ActionEvent event) {
        VBox vboxNode = new VBox(8);
        Label label = new Label("ID: " +  size);
        vboxNode.getChildren().add(label);
        HBox hbox1 = new HBox(8);
        Label towerIdLabel = new Label("Tower ID:");
        TextField towerIdTextField = new TextField();
        hbox1.getChildren().addAll(towerIdLabel, towerIdTextField);
        vboxNode.getChildren().add(hbox1);
        HBox hbox2 = new HBox(8);
        Label requiredIdsLabel = new Label("Required IDs:");
        TextField requiredIdsTextField = new TextField();
        hbox2.getChildren().addAll(requiredIdsLabel, requiredIdsTextField);
        vboxNode.getChildren().add(hbox2);
        HBox hbox3 = new HBox(8);
        Label costLabel = new Label("Cost:");
        TextField costTextField = new TextField();
        hbox3.getChildren().addAll(costLabel, costTextField);
        vboxNode.getChildren().add(hbox3);

        Label maxHealthLabel = new Label("Max health:");
        Label demolitionCurrencyLabel = new Label("Demolition currency:");
        Label actionRateLabel = new Label("Action rate:");
        Label actionRangeLabel = new Label("Action range:");
        Label damageLabel = new Label("Damage:");
        Label valueLabel = new Label("Value:");
        TextField maxHealthTextField = new TextField();
        TextField demolitionCurrencyTextField = new TextField();
        TextField actionRateTextField = new TextField();
        TextField actionRangeTextField = new TextField();
        TextField damageTextField = new TextField();
        TextField valueTextField = new TextField();
        HBox maxHealthHBox = new HBox(8, maxHealthLabel, maxHealthTextField);
        HBox demolitionCurrencyHBox = new HBox(8, demolitionCurrencyLabel, demolitionCurrencyTextField);
        HBox actionRateHBox = new HBox(8, actionRateLabel, actionRateTextField);
        HBox actionRangeHBox = new HBox(8, actionRangeLabel, actionRangeTextField);
        HBox damageHBox = new HBox(8, damageLabel, damageTextField);
        HBox valueHBox = new HBox(8, valueLabel, valueTextField);
        VBox vBox = new VBox(8);
        Label modifier = new Label("Modifiers");
        vBox.getChildren().addAll(modifier, maxHealthHBox, demolitionCurrencyHBox, actionRateHBox, actionRangeHBox, damageHBox, valueHBox);
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.getChildren().add(vBox);
        vboxNode.getChildren().add(hBox);
        treeNodes.getChildren().add(vboxNode);
        size++;
    }
}
