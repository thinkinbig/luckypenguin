package pgdp.luckypenguine.model;

import pgdp.luckypenguine.model.fields.*;
import pgdp.util.MiniJava;

import java.util.HashMap;
import java.util.Map;


public class Board {
    private int nums;
    private int ptr;
    private Penguin[] players;
    private Map<Integer, Field> fields = new HashMap<>();

    public Board(int nums, int fish) {

        this.nums = nums;
        players = new Penguin[nums];
        makeFields();
        for (int i = 0; i < nums; i++) {
            players[i] = new Penguin(fish);
        }


    }

    private void makeFields() {
        fields.put(2, new Lucky(0, 2));
        fields.put(3, new Normal(0, 3));
        fields.put(4, new Normal(0, 4));
        fields.put(5, new Normal(0, 5));
        fields.put(6, new Normal(0, 6));
        fields.put(7, new Wedding(0, 7));
        fields.put(8, new Normal(0, 8));
        fields.put(9, new Normal(0, 9));
        fields.put(10, new Normal(0, 10));
        fields.put(11, new Normal(0, 11));
        fields.put(12, new King(0, 12));
    }


    // it is not a good implementation, actually, this method should be written in class Penguin and use Observer
    // pattern to notify Board to change player
    public boolean run(int f, int s) {
        int player = ptr;
        writeBoard();
        MiniJava.write("Pinguin" + ptr + " ist dran:");
        int dice = f + s;
        MiniJava.write(f + " + " +  s + " = " + dice + " wurde gewürfelt");
        Field field = fields.get(dice);
        Penguin cur = players[ptr];
        field.action(fields, cur);
        next();
        if (player == ptr) {
            MiniJava.write("Sie sind der letzte mitspielende Pinguin! Sie gewinnen alle Fische auf dem Brett!");
            return false;
        }
        int quit = MiniJava.read("Geben Sie 1 ein, um jetzt das Spiel zu verlassen:");
        if (quit == 1) { players[ptr].quit(); }
        return true;
    }


    public int next() {
        do {
            ptr = (ptr + 1) % nums;
        } while (players[ptr].isGameOver());
        return ptr;
    }

    private void writeBoard() {
        int f3 = fields.get(3).getFish();
        int f4 = fields.get(4).getFish();
        int f5 = fields.get(5).getFish();
        int f6 = fields.get(6).getFish();
        int f7 = fields.get(7).getFish();
        int f8 = fields.get(8).getFish();
        int f9 = fields.get(9).getFish();
        int f10 = fields.get(10).getFish();
        int f11 = fields.get(11).getFish();
        MiniJava.writeBoard(f3, f4, f5, f6, f7, f8, f9, f10, f11);
    }

    public void round(int f, int w) {
        while (run(f, w)) { }
        int value = 0;
        for (Penguin g : players) {
            if (!g.isGameOver()) {
                value = g.fish();
                MiniJava.write("Die Gewinnerpinguine mit " + value + " Fischen:");
            }
        }

        for (int i = 0; i < nums; i++) {
            if (players[i].fish() == value) {
                MiniJava.write("Pinguin " + i);
            }
        }

    }


}
