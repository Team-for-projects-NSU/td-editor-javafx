package editor.towerdefence.model.tech_tree;

import java.util.ArrayList;
import java.util.List;

public class TechTreeNode {
    private int id;
    private int cost;
    private final List<TechTreeUpgrade> upgrades;
    private final List<Integer> parentIds;

    public TechTreeNode(int id) {
        this.id = id;
        this.cost = 0;
        upgrades = new ArrayList<>();
        parentIds = new ArrayList<>();
    }

    public void addUpgrade(TechTreeUpgrade upgrade) {
        upgrades.add(upgrade);
    }

    public void addParent(int parentId) {
        parentIds.add(parentId);
    }
    public List<TechTreeUpgrade> getUpgrades() {
        return upgrades;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getParentIds() {
        return parentIds;
    }

    public int getCost() {
        return cost;
    }
}
