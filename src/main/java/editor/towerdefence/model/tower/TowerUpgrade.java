package editor.towerdefence.model.tower;

import java.util.Map;

public class TowerUpgrade {
    private int price;
    private Map<String, Float> modifiers;

    public TowerUpgrade() {
    }

    public TowerUpgrade(int price, Map<String, Float> modifiers) {
        this.price = price;
        this.modifiers = modifiers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<String, Float> getModifiers() {
        return modifiers;
    }

    public void setModifiers(Map<String, Float> modifiers) {
        this.modifiers = modifiers;
    }
}
