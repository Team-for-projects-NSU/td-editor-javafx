package editor.towerdefence.controller;

import editor.towerdefence.model.enemy.Enemy;
import editor.towerdefence.model.enemy.EnemyList;

import java.util.HashMap;
import java.util.Map;

public class EnemyUpdater {
    private EnemyList enemyList;

    public EnemyUpdater() {
        enemyList = new EnemyList();
    }

    public void addChanges(int id, String name, String maxHealth, String reward, String spriteFileName, String speed,
                           String actionType, String actionRate, String actionRange, String actionParameter, String actionValue) {
        if (enemyList.getEnemies().size() <= id) {
            int amountToCreate = id - enemyList.getEnemies().size() + 1;
            for (int i = 0; i < amountToCreate; i++) {
                Enemy newEnemy = new Enemy();
                enemyList.addEnemy(newEnemy);
            }
        }
        Enemy enemy = enemyList.getEnemies().get(id);
        enemy.setId(id);
        enemy.setName(name);
        enemy.setMaxHealth(Integer.parseInt(maxHealth));
        enemy.setReward(Integer.parseInt(reward));
        enemy.setSpriteFileName(spriteFileName);
        enemy.setSpeed(Integer.parseInt(speed));
        Enemy.ActionType type = Enemy.ActionType.valueOf(actionType);
        enemy.setActionType(type);
        enemy.setActionRate(Float.parseFloat(actionRate));
        enemy.setActionRange(Integer.parseInt(actionRange));
//        Map<String, Float> actionParams = new HashMap<>();
//        actionParams.put(actionParameter, Float.parseFloat(actionValue));
        enemy.addActionParameter(actionParameter, Float.parseFloat(actionValue));
    }

    public Enemy getEnemyById(int id) {
        if (id >= enemyList.getEnemies().size()) {
            return new Enemy();
        }
        return enemyList.getEnemies().get(id);
    }
}
