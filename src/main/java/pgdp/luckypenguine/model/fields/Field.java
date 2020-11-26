package pgdp.luckypenguine.model.fields;

import pgdp.luckypenguine.model.Penguin;

import java.util.Map;

public abstract class Field {
    protected int index;
    protected int fish;


    public Field(int fish, int index) {
        this.fish = fish;
        this.index = index;
    }

    public int getFish() {
        return this.fish;
    }

    public abstract boolean action(Map<Integer, Field> fields, Penguin penguin);
}
