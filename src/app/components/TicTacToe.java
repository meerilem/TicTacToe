package app.components;


import java.awt.*;
import java.util.*;
import java.util.List;

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
                createCell(new Position(i, j));
            }
        }
    }

    private void createCell(Position position) {
        Cell cell = new Cell();
        grid.addCell(cell, position);
        cell.onClick(() -> {
            if (movesMade % 2 == 0) makeMove(X, position);
            else makeMove(O, position);
        });
    }

    boolean isEndOfGame() {
        return gameResult() != GameResult.IN_PROGRESS;
    }

    GameResult gameResult() {
        List<List<Position>> positionsListOfList = makeAListOfPositions();
        for (List<Position> positionList : positionsListOfList) {
            if (grid.cell(positionList.get(0)).state() == grid.cell(positionList.get(1)).state() &&
                    grid.cell(positionList.get(0)).state() == grid.cell(positionList.get(2)).state() &&
                    grid.cell(positionList.get(0)).state() == Cell.State.O) {
                return GameResult.O_WON;
            }
            else if (grid.cell(positionList.get(0)).state() == grid.cell(positionList.get(1)).state() &&
                    grid.cell(positionList.get(0)).state() == grid.cell(positionList.get(2)).state() &&
                    grid.cell(positionList.get(0)).state() == Cell.State.X) {
                return GameResult.X_WON;
            }
        }
        if (movesMade == 9) {
            return GameResult.TIE;
        }
        return GameResult.IN_PROGRESS;
    }

    private List<List<Position>> makeAListOfPositions() {
        List<List<Position>> positionsListOfList = new ArrayList();

        List<Position> rows0 = new LinkedList<Position>() {
            {
                add(new Position(0, 0));
                add(new Position(0, 1));
                add(new Position(0, 2));
            }
        };
        positionsListOfList.add(rows0);

        List<Position> rows1 = new ArrayList<Position>() {{
            add(new Position(1, 0));
            add(new Position(1, 1));
            add(new Position(1, 2));
        }};
        positionsListOfList.add(rows1);

        List<Position> rows2 = new ArrayList<Position>() {{
            add(new Position(2, 0));
            add(new Position(2, 1));
            add(new Position(2, 2));
        }};
        positionsListOfList.add(rows2);

        List<Position> columns0 = new ArrayList<Position>() {{
            add(new Position(0, 0));
            add(new Position(1, 0));
            add(new Position(2, 0));
        }};
        positionsListOfList.add(columns0);

        List<Position> columns1 = new ArrayList<Position>() {{
            add(new Position(0, 1));
            add(new Position(1, 1));
            add(new Position(2, 1));
        }};
        positionsListOfList.add(columns1);

        List<Position> columns2 = Arrays.asList(
                new Position(0, 2),
                new Position(1, 2),
                new Position(2, 2)
        );
        positionsListOfList.add(columns2);

        List<Position> diagonal1 = new ArrayList<Position>() {{
            add(new Position(0, 0));
            add(new Position(1, 1));
            add(new Position(2, 2));
        }};
        positionsListOfList.add(diagonal1);

        List<Position> diagonal2 = new ArrayList<Position>() {{
            add(new Position(0, 2));
            add(new Position(1, 1));
            add(new Position(2, 0));
        }};
        positionsListOfList.add(diagonal2);

        return positionsListOfList;
    }

    public Container component() {
        return grid.component();
    }

    public void moveX(int x, int y) {
        makeMove(X, new Position(x, y));
    }

    public void moveO(int x, int y) {
        makeMove(O, new Position(x, y));
    }

    void makeMove(Cell.State state, Position position) {
        grid.cell(position).makeMove(state);
        movesMade++;
        System.out.println("Game result: " + gameResult());
    }

    enum GameResult {
        X_WON,
        O_WON,
        TIE,
        IN_PROGRESS
    }
}
