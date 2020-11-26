package pgdp.luckypenguine.model.fields;

import pgdp.luckypenguine.model.Penguin;
import pgdp.util.MiniJava;

import java.util.Map;

public class Normal extends Field {

    public Normal(int fish, int index) {
        super(fish, index);
    }

    @Override
    public boolean action(Map<Integer, Field> fields, Penguin penguin) {
        if (super.fish == 0) {
            if (penguin.dropFish(1)) {
                super.fish = 1;
                // it's not a good practise to put the output in model, but anyway :)
                MiniJava.write("Sie legen einen Fisch auf F" + index + ".");
                penguin.printFish();
                return false;
            }
            return true;
        }
        MiniJava.write("Sie nehmen den Fisch von F" + index + ".");
        penguin.addFish(super.fish);
        penguin.printFish();
        return true;
    }

}
