package editor.towerdefence.controller;

import editor.towerdefence.model.level.Level;
import editor.towerdefence.model.level.LevelList;
import editor.towerdefence.model.level.Wave;
import editor.towerdefence.view.single.WaveRecord;

import java.util.List;

public class LevelUpdater {
    LevelList levelList;

    public LevelUpdater() {
        levelList = new LevelList();
    }

    public void addChanges(int id, String wavesDelay, String startingCurrency, String reward, String backgroundTextureName,
                           String plotTextureName, String roadTextureName, List<WaveRecord> waves, String mapId) {

        if (levelList.getLevels().size() <= id) {
            int amountToCreate = id - levelList.getLevels().size() + 1;
            for (int i = 0; i < amountToCreate; i++) {
                levelList.addLevel(new Level());
            }
        }

        Level level = levelList.getLevels().get(id);
        level.setId(id);
        level.setStartingCurrency(Integer.parseInt(startingCurrency));
        level.setReward(Integer.parseInt(reward));
        level.setBackgroundTextureName(backgroundTextureName);
        level.setPlotTextureName(plotTextureName);
        level.setRoadTextureName(roadTextureName);
        level.setMapID(Integer.parseInt(mapId));

        for (WaveRecord waveRecord : waves) {
            Wave wave = new Wave();
            wave.setWaveDelay(Integer.parseInt(wavesDelay));
            wave.setEnemyCount(Integer.parseInt(waveRecord.enemyAmount));
            wave.setEnemyInterval(Integer.parseInt(waveRecord.enemyInterval));
            for (String type : waveRecord.enemyTypes.split(", ")) {
                wave.addEnemyType(Integer.parseInt(type));
            }
        }
    }

    public Level getLevelById(int id) {
        if (id >= levelList.getLevels().size()) {
            return new Level();
        }
        return levelList.getLevels().get(id);
    }
}
