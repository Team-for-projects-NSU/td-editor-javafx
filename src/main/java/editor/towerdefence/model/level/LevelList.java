package editor.towerdefence.model.level;

import java.util.ArrayList;
import java.util.List;

public class LevelList {
    private List<Level> levels;

    public LevelList() {
        levels = new ArrayList<>();
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }
}
