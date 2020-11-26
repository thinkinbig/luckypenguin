package pgdp.luckypenguine.view;

import pgdp.luckypenguine.model.Board;
import pgdp.util.MiniJava;

public class ConsoleView {

    public static void startConsoleGame() {
        int nums;
        while ((nums = MiniJava.readInt("Anzahl Pinguine:")) <= 1) {
            MiniJava.write("Anzahl Pinguine soll >1 sein:");
        }
        int fish;
        while ((fish = MiniJava.readInt("Anfangsfische pro Pinguin:")) <= 0) {
            MiniJava.write("Anfangsfische soll >0 sein:");
        }

        Board board = new Board(nums, fish);
        int f = MiniJava.randomInt(1, 6);
        int w = MiniJava.randomInt(1, 6);
        board.round(f, w);
    }
}
