package VectorDesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

class UndoGUI extends JDialog {
    UndoGUI(CanvasDrawing canvasGraphics) {
        // Setup Dialog box properties
        getContentPane().setLayout(new BorderLayout());
        setTitle("Canvas History");
        setModal(true);
        setMinimumSize(new Dimension(200,300));
        setPreferredSize(new Dimension(200, 300));

        // Add scroll pane
        JList<String> canvasHistory = new JList<>(canvasGraphics.canvasObjectsToString());
        canvasHistory.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(canvasHistory);
        scrollPane.setSize(new Dimension(100, 100));

        // Add revert button
        JButton selectButton = new JButton("Revert to selection");

        // Add Elements
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(selectButton, BorderLayout.SOUTH);

        // Listen for exit button
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                canvasGraphics.canvasHistoryControl(canvasHistory.getSelectedIndex(), "cancel");
                dispose();
            }
        });

        // Listen for list selection
        canvasHistory.addListSelectionListener(evt -> {
            canvasGraphics.canvasHistoryControl(canvasHistory.getSelectedIndex(), "preview");
        });

        // Listen for revert button
        selectButton.addActionListener(evt -> {
            canvasGraphics.canvasHistoryControl(canvasHistory.getSelectedIndex(), "save");
            dispose();
        });

        pack();
    }
}