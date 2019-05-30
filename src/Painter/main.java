/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Painter;

import javax.swing.*;
import javax.swing.colorchooser.*;

/**
 *
 * @author James
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI mainGUI = new GUI();
                mainGUI.setVisible(true);
            }
        });
    }
}