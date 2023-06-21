package editor.towerdefence.model;

import com.google.gson.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Serializer {

    private final Gson gson;
    private final Map<String, String> fileNames;
    private final String path;

    public Serializer(String path) {
        gson = new GsonBuilder().setPrettyPrinting().create();

        this.path = path;

        fileNames = new HashMap<>();
        fileNames.put("Towers", "BuildingsConfig.json");
        fileNames.put("Enemies", "EnemiesConfig.json");
        fileNames.put("Levels", "LevelsConfig.json");
        fileNames.put("Maps", "MapsConfig.json");
        fileNames.put("TechTree", "TechTreeConfig.json");
    }

    public void serializeObject(String filePath, Object object) {
        File file = new File(filePath);
        Writer writer;
        try {
            writer = new FileWriter(file, false);
            gson.toJson(object, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Exception thrown while writing to file " + filePath);
            e.printStackTrace();
        }
    }

//    public void serializeAll(TowerList towers, EnemyList enemies, LevelList levels, LevelMapList maps, TechTree techTree) {
//        serializeObject(path.concat(fileNames.get("Towers")), towers.getTowers());
//        serializeObject(path.concat(fileNames.get("Enemies")), enemies.getEnemies());
//        serializeObject(path.concat(fileNames.get("Levels")), levels.getLevels());
//        serializeObject(path.concat(fileNames.get("Maps")), maps.getMaps());
//        serializeObject(path.concat(fileNames.get("TechTree")), techTree);
//    }
}
