package app;

import app.components.ApplicationFrame;
import app.components.TicTacToe;

public class Main {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        new ApplicationFrame(ticTacToe.component());
    }
}
