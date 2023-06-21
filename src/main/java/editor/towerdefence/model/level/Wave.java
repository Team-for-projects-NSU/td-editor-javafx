package editor.towerdefence.model.level;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    private int waveDelay;
    private int enemyCount;
    private int enemyInterval;
    private List<Integer> enemyTypes;

    public Wave() {
        enemyTypes = new ArrayList<>();
    }

    public Wave(int waveDelay, int enemyCount, int enemyInterval) {
        enemyTypes = new ArrayList<>();
        this.waveDelay = waveDelay;
        this.enemyCount = enemyCount;
        this.enemyInterval = enemyInterval;
    }

    public int getWaveDelay() {
        return waveDelay;
    }

    public void setWaveDelay(int waveDelay) {
        this.waveDelay = waveDelay;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }

    public int getEnemyInterval() {
        return enemyInterval;
    }

    public void setEnemyInterval(int enemyInterval) {
        this.enemyInterval = enemyInterval;
    }

    public List<Integer> getEnemyTypes() {
        return enemyTypes;
    }

    public void setEnemyTypes(List<Integer> enemyTypes) {
        this.enemyTypes = enemyTypes;
    }

    public void addEnemyType(int enemyTypeID) {
        enemyTypes.add(enemyTypeID);
    }

    public void removeEnemyType(int typeIndex) {
        enemyTypes.remove(typeIndex);
    }
}
