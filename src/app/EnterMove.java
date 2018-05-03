package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterMove {

  public static void isMoveValid(int x, int y) {
    if (x > 2 || x < 0) throw new ArithmeticException("x coordinate is our of range (0, 1, 2)");
    if (y > 2 || y < 0) throw new ArithmeticException("y coordinate is out of range (0, 1, 2)");

  }

  public static void nextMove() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Give next move's coordinates ");

    String name = null;
    try {
      name = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Next move is: " + name);


  }

}
