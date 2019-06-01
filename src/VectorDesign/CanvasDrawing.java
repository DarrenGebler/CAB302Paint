package VectorDesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import VectorDesign.VectorTools.*;

/**
 * Handles canvas setup and vector drawing
 */
public class CanvasDrawing extends JPanel {
    // GUI object
    GUI gui;

    // Current shape to draw for preview
    private Shapes currentObject;

    // All shapes stored in a list
    private GraphicsContainer canvasGraphics = new GraphicsContainer(1);

    // Mouse position
    private Point clickPos;
    private Point dragPos;

    // Tool selection
    private Tools currentTool;

    /**
     * Setup the JPanel extension for drawing, handle canvas mouse events
     * @param gui takes the gui object for use in resizing and event listening
     */
    public CanvasDrawing(GUI gui) {
        this.gui = gui;
        this.setBackground(Color.WHITE);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        this.setPreferredSize(new Dimension(500,500));


        /**
         * Mouse button listener for canvas events
         */
        addMouseListener(new MouseAdapter() {

            /**
             * Listens for mouse down event to create shapes on the canvas from user input
             */
            public void mousePressed(MouseEvent e) {
                clickPos = e.getPoint();

                switch (currentTool) {
                    case PLOT:
                        currentObject = new Line(getVecCoord(clickPos.x), getVecCoord(clickPos.y), getVecCoord(clickPos.x), getVecCoord(clickPos.y), new Color(100,100,100));
                        break;
                    case LINE:
                        currentObject = new Line(getVecCoord(clickPos.x), getVecCoord(clickPos.y), getVecCoord(clickPos.x), getVecCoord(clickPos.y), new Color(100,100,100));
                        break;
                    default:
                        currentTool = Tools.PLOT;
                }
            }

            /**
             * Listens for mouse up event to finalise shape creation or add new points for polygons.
             * @param e
             */
            public void mouseReleased(MouseEvent e) {
                canvasGraphics.addObject(currentObject);
                clickPos = null;
                repaint();
            }
        });

        /**
         * Mouse move listener for canvas events
         */
        addMouseMotionListener(new MouseMotionAdapter() {

            /**
             * Listens for mouse dragging event to resize shapes while user draws
             * @param e
             */
            public void mouseDragged(MouseEvent e) {
                dragPos = e.getPoint();
                currentObject.preview(getVecCoord(dragPos.x), getVecCoord(dragPos.y));
                repaint();
            }

            /**
             * Listens for mouse moved event to redraw line while user draws polygon
             * @param e
             */
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    public void setTool(Tools tool) {
        currentTool = tool;
    }

    /**
     * Paints 2D graphics to the vector canvas
     * @param g
     */
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;

        // Draw all objects currently in the canvasGraphics list
        for (Shapes object: canvasGraphics.getObjects()) {
            object.draw(graphics, canvasGraphics.getSize());
        }

        // Update object preview
        if (clickPos != null) {
            currentObject.draw(graphics, canvasGraphics.getSize());
        }
    }

    /**
     * Resizes the vector canvas (maintaining aspect ratio) when the user resizes the window.
     * @param containerSize
     */
    public void canvasResize(Dimension containerSize) {
        int minEdge = Math.min(containerSize.height, containerSize.width);
        gui.vectorCanvas.setPreferredSize(new Dimension(minEdge - 50,minEdge - 50));

        canvasGraphics.setSize(minEdge - 50);
    }

    /**
     * Returns the vector coordinate from a pixel coordinate
     * @param canvasPos pixel position
     */
    private double getVecCoord(int canvasPos) {
        return (double) canvasPos / (double) canvasGraphics.getSize();
    }
}