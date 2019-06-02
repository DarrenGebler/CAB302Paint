package VectorDesign;

import javax.swing.*;

/**
 * Main entrypoint
 * @author James Hassett, Darren Gebler
 */
public class main {

    /**
     * Main program function, initialises the GUI from which other classes work
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Create the GUI instance
                GUI mainGUI = new GUI();
                mainGUI.setVisible(true);
            }
        });
    }
}
