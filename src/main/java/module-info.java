module editor.towerdefence {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports editor.towerdefence.model.tower;
    exports editor.towerdefence.model.tech_tree;
    exports editor.towerdefence.model.level;
    exports editor.towerdefence.model.enemy;
    opens editor.towerdefence.model.tower to com.google.gson;
    opens editor.towerdefence.model.tech_tree to com.google.gson;
    opens editor.towerdefence.model.level to com.google.gson;
    opens editor.towerdefence.model.enemy to com.google.gson;
    exports editor.towerdefence;
    opens editor.towerdefence to javafx.fxml;
    opens editor.towerdefence.view to javafx.fxml;
    exports editor.towerdefence.view;
    exports editor.towerdefence.view.single;
    opens editor.towerdefence.view.single;
    exports editor.towerdefence.view.multi;
    opens editor.towerdefence.view.multi;
}
