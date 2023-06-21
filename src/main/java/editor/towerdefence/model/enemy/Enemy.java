package editor.towerdefence.model.enemy;

import java.util.HashMap;
import java.util.Map;

public class Enemy {
    public enum ActionType {
        Default,
        DoNothing,
        BasicAttack,
    }

    private int id;
    private String name;
    private int maxHealth;
    private int reward;
    private String spriteFileName;
    private int speed;
    private ActionType actionType;
    private float actionRate;
    private int actionRange;
    private Map<String, Float> actionParameters;

    public Enemy(){
    }
    public Enemy(int id, String name, int maxHealth, int reward, String spriteFileName, int speed,
                 ActionType actionType, float actionRate, int actionRange) {
        this.id = id;
        this.name = name;
        this.maxHealth = maxHealth;
        this.reward = reward;
        this.spriteFileName = spriteFileName;
        this.speed = speed;
        this.actionType = actionType;
        this.actionRate = actionRate;
        this.actionRange = actionRange;
        this.actionParameters = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getSpriteFileName() {
        return spriteFileName;
    }

    public void setSpriteFileName(String spriteFileName) {
        this.spriteFileName = spriteFileName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public float getActionRate() {
        return actionRate;
    }

    public void setActionRate(float actionRate) {
        this.actionRate = actionRate;
    }

    public int getActionRange() {
        return actionRange;
    }

    public void setActionRange(int actionRange) {
        this.actionRange = actionRange;
    }

    public Map<String, Float> getActionParameters() {
        return actionParameters;
    }

    public void addActionParameter(String parameter, float value) {
        actionParameters.put(parameter, value);
    }
}
