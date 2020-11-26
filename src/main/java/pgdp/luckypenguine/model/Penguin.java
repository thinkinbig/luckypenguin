package pgdp.luckypenguine.model;

import pgdp.util.MiniJava;

public class Penguin implements Comparable<Penguin>{
    private int fish;
    private boolean gameOver;

    public boolean isGameOver() {
        return this.gameOver;
    }

    public Penguin(int fish) {

        this.fish = fish;
    }

    public void addFish(int number) {
        this.fish += number;
    }

    public boolean dropFish(int number) {
        if (this.fish - number < 0) {
            gameOver = true;
            MiniJava.write("Sie haben jetzt 0 Fische!\n" +
                    "Sie haben alle Fische verloren, daher können Sie nicht mehr spielen!");
        } else {
            this.fish -= number;
        }
        return !gameOver;
    }

    public void printFish() {
        MiniJava.write("Sie haben jetzt " + fish  +" Fische!");
    }

    public void quit() {
        gameOver = true;
    }

    @Override
    public int compareTo(Penguin o) {
        return this.fish - o.fish;
    }

    public int fish() {
        return fish;
    }
}
