module editor.towerdefence {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports editor.towerdefence;
    opens editor.towerdefence to javafx.fxml;
    opens editor.towerdefence.view to javafx.fxml;
    exports editor.towerdefence.view;
    exports editor.towerdefence.view.single;
    opens editor.towerdefence.view.single;
}
