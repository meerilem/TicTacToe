package app.components;


import app.components.Cell;
import app.components.Grid;

import javax.swing.*;

import java.awt.*;

import static app.components.Cell.Player.O;
import static app.components.Cell.Player.X;

public class TicTacToe {

  private final Grid grid = new Grid();

  private int movesMade = 0;

  public TicTacToe() {
    addCellsToGrid();
  }

  private void addCellsToGrid() {
    createCell(0, 0);
    createCell(0, 1);
    createCell(0, 2);
    createCell(1, 0);
    createCell(1, 1);
    createCell(1, 2);
    createCell(2, 0);
    createCell(2, 1);
    createCell(2, 2);
  }

  private void createCell(int x, int y) {
    Cell cell = new Cell();
    grid.addCell(cell, x, y);
    cell.onClick(() -> {
      if (movesMade % 2 == 0) cell.makeMove(X);
      else cell.makeMove(O);
      movesMade++;
    });
  }

  public Container component() {
    return grid.component();
  }
}
