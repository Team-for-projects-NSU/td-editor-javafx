package editor.towerdefence.model.tech_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TechTree {

    private final Map<Integer, List<TechTreeNode>> rootNodes;

    public TechTree() {
        rootNodes = new HashMap<>();
    }

    public void putTowerNodes(int towerId, List<TechTreeNode> towerUpgrades) {
        rootNodes.put(towerId, towerUpgrades);
    }

    public void addTowerNode(int towerId, TechTreeNode towerUpgrade) {
        List<TechTreeNode> list;
        if (!rootNodes.containsKey(towerId)) {
            list = new ArrayList<>();
            rootNodes.put(towerId, list);
        } else {
            list = rootNodes.get(towerId);
        }
        list.add(towerUpgrade);
    }

    public Map<Integer, List<TechTreeNode>> getRootNodes() {
        return rootNodes;
    }
}
