package editor.towerdefence.controller;

public class MainUpdater {
    private static MainUpdater instance;
    private TowerUpdater towerUpdater;
    private EnemyUpdater enemyUpdater;
    private LevelUpdater levelUpdater;
    private MultiLevelUpdater multiLevelUpdater;
    private MainUpdater() {
        towerUpdater = new TowerUpdater();
        enemyUpdater = new EnemyUpdater();
        levelUpdater = new LevelUpdater();
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

    public LevelUpdater getLevelUpdater() {
        return levelUpdater;
    }

    public MultiLevelUpdater getMultiLevelUpdater() {
        return multiLevelUpdater;
    }
}