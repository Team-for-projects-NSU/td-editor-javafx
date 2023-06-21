package editor.towerdefence.model.level;

import java.util.ArrayList;
import java.util.List;

public class LevelMapList {
    private List<LevelMap> maps;

    public LevelMapList() {
        maps = new ArrayList<>();
    }

    public List<LevelMap> getMaps() {
        return maps;
    }

    public void setMaps(List<LevelMap> maps) {
        this.maps = maps;
    }

    public void addMap(LevelMap levelMap) {
        maps.add(levelMap);
    }

    public LevelMap getMap(int i) {
        return maps.get(i);
    }
}
