package pgdp.luckypenguine.model.fields;

import pgdp.luckypenguine.model.Penguin;
import pgdp.util.MiniJava;

import java.util.Map;

public class King extends Field {

    public King(int fish, int index) {
        super(fish, index);
    }

    @Override
    public boolean action(Map<Integer, Field> fields, Penguin penguin) {
        int fish = 0;
        MiniJava.write("Königspinguin! Sie gewinnen alle Fische auf dem Brett!");
        for (Map.Entry<Integer, Field> entry : fields.entrySet()) {
            fish += entry.getValue().fish;
        }
        penguin.addFish(fish);
        penguin.printFish();
        return true;
    }
}
