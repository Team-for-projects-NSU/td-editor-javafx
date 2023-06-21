package editor.towerdefence.model.effect;

public class Effect {

    private String name;
    private int rate;
    private int duration;

    public Effect(){
    }
    public Effect(String name, int rate, int duration) {
        this.name = name;
        this.rate = rate;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
