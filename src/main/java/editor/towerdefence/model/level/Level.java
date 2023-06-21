package editor.towerdefence.model.level;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int id;
    private int startingCurrency;
    private int reward;
    private String backgroundTextureName;
    private String plotTextureName;
    private String roadTextureName;
    private List<Wave> waves;
    private int mapID;

    public Level() {
        waves = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartingCurrency() {
        return startingCurrency;
    }

    public void setStartingCurrency(int startingCurrency) {
        this.startingCurrency = startingCurrency;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getBackgroundTextureName() {
        return backgroundTextureName;
    }

    public void setBackgroundTextureName(String backgroundTextureName) {
        this.backgroundTextureName = backgroundTextureName;
    }

    public String getPlotTextureName() {
        return plotTextureName;
    }

    public void setPlotTextureName(String plotTextureName) {
        this.plotTextureName = plotTextureName;
    }

    public String getRoadTextureName() {
        return roadTextureName;
    }

    public void setRoadTextureName(String roadTextureName) {
        this.roadTextureName = roadTextureName;
    }

    public List<Wave> getWaves() {
        return waves;
    }

    public void setWaves(List<Wave> waves) {
        this.waves = waves;
    }

    public void addWave(Wave wave) {
        waves.add(wave);
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }
}
