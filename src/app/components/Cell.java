package app.components;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.AbstractButton;
import javax.swing.JButton;

public class Cell {

  AbstractButton component;
  State state = State.EMPTY;

  public Cell() {
    component = new JButton();
    Dimension size = new Dimension(50, 50);
    component.setPreferredSize(size);
  }

  public Component component() {
    return component;
  }

  public void makeMove(State state) {
    component.setText(state.name());
    component.setEnabled(false);
    this.state = state;

  }

  public void onClick(Runnable action) {
    component.addActionListener(e -> action.run());
  }

  public State state() {
    return state;
  }

  public enum State {
    X, O, EMPTY
  }

}
