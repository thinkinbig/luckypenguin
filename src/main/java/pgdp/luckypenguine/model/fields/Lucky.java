package pgdp.luckypenguine.model.fields;

import pgdp.luckypenguine.model.Penguin;
import pgdp.util.MiniJava;

import java.util.Map;

public class Lucky extends Field{
    public Lucky(int fish, int index) {
        super(fish, index);
    }

    @Override
    public boolean action(Map<Integer, Field> fields, Penguin penguin) {
        int fish = 0;
        MiniJava.write("Glückspinguin! Sie gewinnen alle Fische auf dem Brett außer von F7!");
        for (Map.Entry<Integer, Field> entry : fields.entrySet()) {
            if (entry.getKey() == 7) {
                continue;
            }
            fish += entry.getValue().fish;
        }
        penguin.addFish(fish);
        penguin.printFish();
        return true;
    }
}
