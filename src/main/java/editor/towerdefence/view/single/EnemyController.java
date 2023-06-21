package editor.towerdefence.view.single;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class EnemyController {
    private int enemiesSize = 1;
    @FXML
    private VBox enemyIdsPanel;
    @FXML
    private Label enemyId;
    @FXML
    private TextField enemyName;
    @FXML
    private TextField enemyHealth;
    @FXML
    private TextField enemyCost;
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
        enemyActionType.getItems().addAll("Default", "Do nothing", "BasicAttack", "GenerateCurrency");
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
    }
}
