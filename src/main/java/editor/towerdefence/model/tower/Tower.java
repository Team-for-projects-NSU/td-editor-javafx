package editor.towerdefence.model.tower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tower {
    public enum ActionType {
        Default,
        DoNothing,
        BasicAttack,
        GenerateCurrency
    }

    private int id;
    private String name;
    private int maxHealth;
    private int cost;
    private String spriteName;
    private int demolitionCurrency;
    private ActionType actionType;
    private int actionRate;
    private int actionRange;
    private Map<String, Float> actionParams;
    private List<Integer> upgradeIDs;
    // добавить эффекты

    public Tower() {
        this.id = 0;
        this.name = "";
        this.maxHealth = 0;
        this.cost = 0;
        this.spriteName = "";
        this.demolitionCurrency = 0;
        this.actionType = ActionType.Default;
        this.actionRate = 0;
        this.actionRange = 0;
        this.actionParams = new HashMap<>();
        this.actionParams.put("damage", (float) 0);
    }

    public Tower(int id, String name, int maxHealth, int cost, String spriteName, int demolitionCurrency,
                 ActionType actionType, int actionRate, int actionRange, Map<String, Float> actionParams,
                 List<Integer> upgradeIDs) {
        this.id = id;
        this.name = name;
        this.maxHealth = maxHealth;
        this.cost = cost;
        this.spriteName = spriteName;
        this.demolitionCurrency = demolitionCurrency;
        this.actionType = actionType;
        this.actionRate = actionRate;
        this.actionRange = actionRange;
        this.actionParams = actionParams;
        this.upgradeIDs = upgradeIDs;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }

    public int getDemolitionCurrency() {
        return demolitionCurrency;
    }

    public void setDemolitionCurrency(int demolitionCurrency) {
        this.demolitionCurrency = demolitionCurrency;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public int getActionRate() {
        return actionRate;
    }

    public void setActionRate(int actionRate) {
        this.actionRate = actionRate;
    }

    public int getActionRange() {
        return actionRange;
    }

    public void setActionRange(int actionRange) {
        this.actionRange = actionRange;
    }

    public Map<String, Float> getActionParams() {
        return actionParams;
    }

    public void setActionParams(Map<String, Float> actionParams) {
        this.actionParams = actionParams;
    }

    public List<Integer> getUpgradeIDs() {
        return upgradeIDs;
    }

    public void setUpgradeIDs(List<Integer> upgradeIDs) {
        this.upgradeIDs = upgradeIDs;
    }
}
