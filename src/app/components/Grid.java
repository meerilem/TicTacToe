package app.components;

import java.awt.*;

public class Grid {

    private Container component;

    public Grid() {
        component = new Container();
        component.setLayout(new GridBagLayout());

    }

    public Container component() {
        return component;
    }

    public void addCell(Cell cell, int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        component.add(cell.component(), c);
    }
}
