package editor.towerdefence.view;

import editor.towerdefence.controller.MainUpdater;
import editor.towerdefence.model.Serializer;
import editor.towerdefence.model.enemy.EnemyList;
import editor.towerdefence.model.level.LevelList;
import editor.towerdefence.model.level.LevelMapList;
import editor.towerdefence.model.tech_tree.TechTree;
import editor.towerdefence.model.tower.TowerList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {
    @FXML
    private void handleGenerateButtonClick(ActionEvent event) {
        Serializer serializer = new Serializer("./");
        serializer.serializeAll(MainUpdater.getInstance().getTowerUpdater().getTowerList(), new EnemyList(), new LevelList(), new LevelList(),
                new LevelMapList(), new LevelMapList(), new TechTree());
    }
}
