package editor.towerdefence.model.tower;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TowerUpgrade {
    private int price;
    private List<Upgrade> modifiers;

    public TowerUpgrade() {
        price = 0;
        modifiers = new ArrayList<Upgrade>();
    }

    public TowerUpgrade(int price, List<Upgrade> modifiers) {
        this.price = price;
        this.modifiers = modifiers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Upgrade> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Upgrade> modifiers) {
        this.modifiers = modifiers;
    }
}
