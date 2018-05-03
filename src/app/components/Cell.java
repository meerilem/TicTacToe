package app.components;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.AbstractButton;
import javax.swing.JButton;

public class Cell {

  AbstractButton component;

  public Cell() {
    component = new JButton();
    Dimension size = new Dimension(50, 50);
    component.setPreferredSize(size);
  }

  public Component component() {
    return component;
  }

  public void makeMove(Player player) {
    component.setText(player.name());
    component.setEnabled(false);
  }

  public void onClick(Runnable action) {
    component.addActionListener(e -> action.run());
  }

  public enum Player {
    X, O
  }

}
