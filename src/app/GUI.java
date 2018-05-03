package app;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {

  private int numClicks = 0;
  JButton btn;

  public static void addButton(JButton btn, Dimension dim, GridBagConstraints c, Container pane, int x, int y) {
    btn.setPreferredSize(dim);
    c.gridx = x;
    c.gridy = y;
    pane.add(btn, c);
  }

  /*public void actionPerformed(ActionEvent e) {
    numClicks++;
    if (numClicks % 2 == 0) btn.setText("X");
    else btn.setText("O");
    btn.setEnabled(false);
    numClicks++;}
  }*/

  public static void addComponentsToPane (Container pane) {
    JButton button;
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    Dimension dim = new Dimension(50, 50);
    c.fill = GridBagConstraints.HORIZONTAL;

    int counter[] = {0};

    JButton finalButton1 = new JButton();
    addButton(finalButton1, dim, c, pane, 0, 0);
    //finalButton1.addActionListener(this);

    finalButton1.addActionListener (e -> {
        if (counter[0] % 2 == 0) finalButton1.setText("X");
        else finalButton1.setText("O");
        finalButton1.setEnabled(false);
        counter[0]++;}
        );

    button = new JButton();
    button.setPreferredSize(dim);
    c.gridx = 1;
    c.gridy = 0;
    pane.add(button, c);
    JButton finalButton2 = button;
    button.addActionListener (e -> {
      if (counter[0] % 2 == 0) finalButton2.setText("X");
      else finalButton2.setText("O");
      finalButton2.setEnabled(false);
      counter[0]++;}
    );

    button = new JButton();
    button.setPreferredSize(dim);
    c.gridx = 0;
    c.gridy = 1;
    pane.add(button, c);
    JButton finalButton3 = button;
    finalButton3.addActionListener (e -> {
      if (counter[0] % 2 == 0) finalButton3.setText("X");
      else finalButton3.setText("O");
      finalButton3.setEnabled(false);
      counter[0]++;}
    );

    button = new JButton();
    button.setPreferredSize(dim);
    c.gridx = 1;
    c.gridy = 1;
    pane.add(button, c);
    JButton finalButton4 = button;
    button.addActionListener (e -> {
      if (counter[0] % 2 == 0) finalButton4.setText("X");
      else finalButton4.setText("O");
      finalButton4.setEnabled(false);
      counter[0]++;
    }
    );
  }

/*
  static int changeButton(JButton buttonX, int number) {
    buttonX.addActionListener (e -> {
      if (number % 2 == 0) buttonX.setText("X");
      else buttonX.setText("O");
      buttonX.setEnabled(false);
      int res = number + 1;
    }
    );
    int res = number + 1;
    return res;
  }
*/

  static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("GridBagLayoutDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Set up the content pane.
    addComponentsToPane(frame.getContentPane());

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }
}
