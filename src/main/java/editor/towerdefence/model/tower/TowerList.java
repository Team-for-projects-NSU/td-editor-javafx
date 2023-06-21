package editor.towerdefence.model.tower;

import java.util.ArrayList;
import java.util.List;

public class TowerList {
    private List<Tower> towers;

    public TowerList() {
        towers = new ArrayList<>();
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public void setTowers(List<Tower> towers) {
        this.towers = towers;
    }

    public void addTower(Tower tower) {
        towers.add(tower);
    }
}
