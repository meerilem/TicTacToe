package app.components;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Grid {

    private Container component = new Container();
    private Map<Position, Cell> cells = new HashMap<>();

    public Grid() {
        component.setLayout(new GridBagLayout());
    }

    public Container component() {
        return component;
    }

    public void addCell(Cell cell, int x, int y) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        component.add(cell.component(), constraints);
        Position position = new Position(x, y);
        cells.put(position, cell);
    }

    public Cell cell(int x, int y) {
        Position position = new Position(x, y);
        return cells.get(position);
    }
}
