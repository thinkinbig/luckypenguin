package pgdp.luckypenguine.model.fields;

import pgdp.luckypenguine.model.Penguin;
import pgdp.util.MiniJava;

import java.util.Map;

public class Wedding extends Field {

    public Wedding(int fish, int index) {
        super(fish, index);
    }

    @Override
    public boolean action(Map<Integer, Field> fields, Penguin penguin) {
        if (penguin.dropFish(1)) {
            MiniJava.write("Hochzeit! Sie schenken einen Fisch und legen ihn auf F" + index + ".");
            return true;
        }
        return false;
    }
}
