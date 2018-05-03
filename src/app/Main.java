package app;

public class Main {

    public static void main(String[] args) {

      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's app.GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          GUI.createAndShowGUI();
        }
      });
    }
}
