package editor.towerdefence.model;

import com.google.gson.*;
import editor.towerdefence.model.enemy.EnemyList;
import editor.towerdefence.model.level.LevelList;
import editor.towerdefence.model.level.LevelMapList;
import editor.towerdefence.model.tech_tree.TechTree;
import editor.towerdefence.model.tower.TowerList;

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
        fileNames.put("Single Levels", "SingleLevelsConfig.json");
        fileNames.put("Multi Levels", "MultiLevelsConfig.json");
        fileNames.put("Single Maps", "SingleMapsConfig.json");
        fileNames.put("Multi Maps", "MultiMapsConfig.json");
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

    public void serializeAll(TowerList towers, EnemyList enemies, LevelList singlePlayerLevels, LevelList multiPlayerLevels, LevelMapList singlePlayerMaps, LevelMapList multiPlayerMaps, TechTree techTree) {
        serializeObject(path.concat(fileNames.get("Towers")), towers.getTowers());
        serializeObject(path.concat(fileNames.get("Enemies")), enemies.getEnemies());
        serializeObject(path.concat(fileNames.get("Single Levels")), singlePlayerLevels.getLevels());
        serializeObject(path.concat(fileNames.get("Multi Levels")), multiPlayerLevels.getLevels());
        serializeObject(path.concat(fileNames.get("Single Maps")), singlePlayerMaps.getMaps());
        serializeObject(path.concat(fileNames.get("Multi Maps")), multiPlayerMaps.getMaps());
        serializeObject(path.concat(fileNames.get("TechTree")), techTree);
    }
}
