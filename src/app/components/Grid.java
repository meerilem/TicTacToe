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

    public void addCell(Cell cell, Position position) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = position.x;
        constraints.gridy = position.y;
        component.add(cell.component(), constraints);
        cells.put(position, cell);
    }

    public Cell cell(Position position) {
        return cells.get(position);
    }
}
