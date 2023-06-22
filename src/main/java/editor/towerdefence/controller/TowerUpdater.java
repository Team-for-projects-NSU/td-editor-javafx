package editor.towerdefence.controller;

import editor.towerdefence.model.tower.Tower;
import editor.towerdefence.model.tower.TowerList;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowerUpdater {
    TowerList towerList;

    public TowerUpdater() {
        towerList = new TowerList();
    }

    public void addChanges(int id, String name, String maxHealth, String cost, String spriteName, String demolitionCurrency,
                           String actionType, String actionRate, String actionRange, List<Pair<String, String>> actionParamList) {
        if (towerList.getTowers().size() <= id) {
            int amountToCreate = id - towerList.getTowers().size() + 1;
            for (int i = 0; i < amountToCreate; i++) {
                Tower newTower = new Tower();
                towerList.addTower(newTower);
            }
        }
        Tower tower = towerList.getTowers().get(id);
        tower.setId(id);
        tower.setName(name);
        tower.setMaxHealth(Integer.parseInt(maxHealth));
        tower.setCost(Integer.parseInt(cost));
        tower.setSpriteName(spriteName);
        tower.setDemolitionCurrency(Integer.parseInt(demolitionCurrency));
        Tower.ActionType type = Tower.ActionType.valueOf(actionType);
        tower.setActionType(type);
        tower.setActionRate(Integer.parseInt(actionRate));
        tower.setActionRange(Integer.parseInt(actionRange));
        Map<String, Float> actionParams = new HashMap<>();
        for (Pair<String, String> pair : actionParamList) {
            String actionParam = pair.getKey();
            String actionParamValue = pair.getValue();
            float value = Float.parseFloat(actionParamValue);
            actionParams.put(actionParam, value);
        }
        tower.setActionParams(actionParams);
    }

    public Tower getTowerById(int id) {
        if (id >= towerList.getTowers().size()) {
            return new Tower();
        }
        return towerList.getTowers().get(id);
    }

}
