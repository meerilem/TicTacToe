package app.components;

import org.junit.Test;

import static app.components.TicTacToe.GameResult.*;
import static org.junit.Assert.*;

public class TicTacToeTest {

    @Test
    public void notEndOfGameWhenEmptyBoard() {
        TicTacToe ticTacToe = new TicTacToe();

        assertFalse(ticTacToe.isEndOfGame());
        assertEquals(IN_PROGRESS, ticTacToe.gameResult());
    }

    /*
    XOX
    XOX
    OXO
     */
    @Test
    public void endOfGameWhenBoardIsFilled() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.moveX(0,0);
        ticTacToe.moveO(0,1);
        ticTacToe.moveX(0,2);
        ticTacToe.moveO(1,1);
        ticTacToe.moveX(1,0);
        ticTacToe.moveO(2,0);
        ticTacToe.moveX(1,2);
        ticTacToe.moveO(2,2);
        ticTacToe.moveX(2,1);

        assertTrue(ticTacToe.isEndOfGame());
        assertEquals(TIE, ticTacToe.gameResult());
    }

    /*
    XXX
    ---
    OO-
     */

    @Test
    public void endOfGameWhenRowIsFilledWithX() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.moveX(0,0);
        ticTacToe.moveO(2,0);
        ticTacToe.moveX(0,1);
        ticTacToe.moveO(2,1);
        ticTacToe.moveX(0,2);

        assertTrue(ticTacToe.isEndOfGame());
        assertEquals(X_WON, ticTacToe.gameResult());
    }


    /*
    -XX
    OOO
    ---
     */
    @Test
    public void endOfGameWhenRowIsFilledWithO() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.moveO(1,0);
        ticTacToe.moveX(0,1);
        ticTacToe.moveO(1,1);
        ticTacToe.moveX(0,2);
        ticTacToe.moveO(1,2);

        assertTrue(ticTacToe.isEndOfGame());
        assertEquals(O_WON, ticTacToe.gameResult());
    }

    /*
    --X
    -OX
    O-X
     */
    @Test
    public void endOfGameWhenColumnIsFilled() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.moveX(0,2);
        ticTacToe.moveO(1,1);
        ticTacToe.moveX(1,2);
        ticTacToe.moveO(2,0);
        ticTacToe.moveX(2,2);

        assertTrue(ticTacToe.isEndOfGame());
        assertEquals(X_WON, ticTacToe.gameResult());
    }

    /*
    --X
    -XO
    X-O
     */
    @Test
    public void endOfGameWhenDiagonalIsFilled() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.moveX(0,2);
        ticTacToe.moveO(1,2);
        ticTacToe.moveX(1,1);
        ticTacToe.moveO(2,2);
        ticTacToe.moveX(2,0);

        assertTrue(ticTacToe.isEndOfGame());
        assertEquals(X_WON, ticTacToe.gameResult());
    }
}
