package editor.towerdefence.controller;

public class MainUpdater {
    private static MainUpdater instance;
    private TowerUpdater towerUpdater;
    private EnemyUpdater enemyUpdater;
    private MainUpdater() {
        towerUpdater = new TowerUpdater();
        enemyUpdater = new EnemyUpdater();
    }

    public static MainUpdater getInstance() {
        if (instance == null) {
            instance = new MainUpdater();
        }
        return instance;
    }

    public TowerUpdater getTowerUpdater() {
        return towerUpdater;
    }

    public EnemyUpdater getEnemyUpdater() {
        return enemyUpdater;
    }
}