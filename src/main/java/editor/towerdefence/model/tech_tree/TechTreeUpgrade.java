package editor.towerdefence.model.tech_tree;

public class TechTreeUpgrade {
    private String upgradedParameter;
    private float modifier;

    public TechTreeUpgrade() {
    }

    public TechTreeUpgrade(String upgradedParameter, float modifier) {
        this.upgradedParameter = upgradedParameter;
        this.modifier = modifier;
    }

    public String getUpgradedParameter() {
        return upgradedParameter;
    }

    public void setUpgradedParameter(String upgradedParameter) {
        this.upgradedParameter = upgradedParameter;
    }

    public float getModifier() {
        return modifier;
    }

    public void setModifier(float modifier) {
        this.modifier = modifier;
    }
}
