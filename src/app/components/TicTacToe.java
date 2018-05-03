package app.components;


import java.awt.*;

import static app.components.Cell.State.O;
import static app.components.Cell.State.X;

public class TicTacToe {

  private final Grid grid = new Grid();

  private int movesMade = 0;

  public TicTacToe() {
    addCellsToGrid();
  }

  private void addCellsToGrid() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        createCell(i, j);
      }
    }
  }

  private void createCell(int x, int y) {
    Cell cell = new Cell();
    grid.addCell(cell, x, y);
    cell.onClick(() -> {
      if (movesMade % 2 == 0) cell.makeMove(X);
      else cell.makeMove(O);
      movesMade++;
      checkForGameEnd();
    });
  }

  private void checkForGameEnd() {
    grid.cell(0, 0).state(); // TODO
  }

  public Container component() {
    return grid.component();
  }
}
