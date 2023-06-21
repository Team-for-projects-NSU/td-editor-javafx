package editor.towerdefence.model.enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyList {
    private List<Enemy> enemies;

    public EnemyList() {
        enemies = new ArrayList<>();
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}

