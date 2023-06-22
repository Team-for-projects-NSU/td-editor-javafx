package editor.towerdefence;

import editor.towerdefence.controller.MainUpdater;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainUpdater mainUpdater = MainUpdater.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("fxml/main-window.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("images/app.png"));
        stage.getIcons().add(icon);
        Scene scene = new Scene(root);
        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}