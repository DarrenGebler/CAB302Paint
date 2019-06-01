package VectorDesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import VectorDesign.VectorTools.*;
import VectorDesign.VectorTools.Polygon;
import VectorDesign.VectorTools.Rectangle;

/**
 * Handles canvas setup and vector drawing
 */
public class CanvasDrawing extends JPanel {
    // GUI object
    GUI gui;

    // Current shape to draw for preview
    private Shapes currentObject;

    // All shapes stored in the canvasGraphics object
    private GraphicsContainer canvasGraphics = new GraphicsContainer(498);

    // List to save undo history to
    private GraphicsContainer undoHistory = new GraphicsContainer(498);

    // Mouse position
    private Point clickPos;
    private Point mousePos;

    // Tool properties
    private Tools currentTool = Tools.PLOT;
    private Color lineColor = new Color(0,0,0);
    private Color fillColor;
    private boolean polygonComplete;

    /**
     * Setup the JPanel extension for drawing, handle canvas mouse events
     * @param gui takes the gui object for use in resizing and event listening
     */
    public CanvasDrawing(GUI gui) {
        this.gui = gui;
        this.setBackground(Color.WHITE);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        this.setPreferredSize(new Dimension(498,498));

        canvasGraphics.setSize(498);


        /**
         * Mouse button listener for canvas events
         */
        addMouseListener(new MouseAdapter() {

            /**
             * Listens for mouse down event to create shapes on the canvas from user input
             */
            public void mousePressed(MouseEvent e) {
                clickPos = e.getPoint();

                // Create a new object depending on tool selected
                switch (currentTool) {
                    case PLOT:
                        currentObject = new Plot(getVecCoord(clickPos.x), getVecCoord(clickPos.y), lineColor);
                        break;
                    case LINE:
                        currentObject = new Line(getVecCoord(clickPos.x), getVecCoord(clickPos.y), getVecCoord(clickPos.x), getVecCoord(clickPos.y), lineColor);
                        break;
                    case RECTANGLE:
                        currentObject = new Rectangle(getVecCoord(clickPos.x), getVecCoord(clickPos.y), getVecCoord(clickPos.x), getVecCoord(clickPos.y), lineColor, fillColor);
                        break;
                    case ELLIPSE:
                        currentObject = new Ellipse(getVecCoord(clickPos.x), getVecCoord(clickPos.y), getVecCoord(clickPos.x), getVecCoord(clickPos.y), lineColor, fillColor);
                        break;
                    case POLYGON:
                        if (currentObject == null) {
                            double[] xValues = {getVecCoord(clickPos.x), getVecCoord(clickPos.x)};
                            double[] yValues = {getVecCoord(clickPos.y), getVecCoord(clickPos.y)};

                            currentObject = new Polygon(xValues, yValues, lineColor, fillColor);
                        } else if (currentTool == Tools.POLYGON && clickPos != null) {
                            polygonComplete = currentObject.addVertex(getVecCoord(mousePos.x), getVecCoord(mousePos.y));
                        }
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
                if (currentTool != Tools.POLYGON || polygonComplete) {
                    // Add new object to canvas container
                    canvasGraphics.addObject(currentObject);

                    // Clear storage
                    currentObject = null;
                    clickPos = null;
                    polygonComplete = false;

                    repaint();
                }
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
                mousePos = e.getPoint();
                currentObject.preview(getVecCoord(mousePos.x), getVecCoord(mousePos.y));
                repaint();
            }

            /**
             * Listens for mouse moved event to redraw line while user draws polygon
             * @param e
             */
            public void mouseMoved(MouseEvent e) {
                if (currentTool == Tools.POLYGON && clickPos != null) {
                    mousePos = e.getPoint();
                    currentObject.preview(getVecCoord(mousePos.x), getVecCoord(mousePos.y));
                    repaint();
                }
            }
        });
    }

    /**
     * Sets the current tool
     * @param tool Tool type from Tools enum
     */
    public void setTool(Tools tool) {
        currentTool = tool;
    }

    /**
     * Sets the line color for shapes
     * @param color Color of shape line
     */
    public void setLineColor(Color color) {
        lineColor = color;
    }

    /**
     * Sets the fill color for shepes
     * @param color Color of shape fill
     */
    public void setFillColor(Color color) {
        fillColor = color;
    }

    /**
     * Returns the vector coordinate from a pixel coordinate
     * @param canvasPos pixel position
     */
    private double getVecCoord(int canvasPos) {
        return (double) canvasPos / (double) canvasGraphics.getSize();
    }

    /**
     * Uses the FileDrawing class to import objects from a vec formatted file
     * Overrides current graphics canvas
     * @param path file path to open
     */
    public void openFile(String path) {
        try {
            // Store current size as file import will clear it
            int canvasSize = canvasGraphics.getSize();

            // Attempt to import the vec file and set the canvas
            canvasGraphics = FileDrawing.fileImport(path);
            canvasGraphics.setSize(canvasSize);

            // Redraw the canvas
            repaint();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void saveFile(String path) {
        try {
            FileDrawing.fileExport(path, canvasGraphics);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /**
     * Provides undo functionality by deleting the last object from
     * the canvasGraphics list.
     * Saves undo to undoHistory to enable redo functionality
     */
    public void undo() {
        if (canvasGraphics.getObjects().size() > 0) {
            // Add last object to redo list
            undoHistory.addObject(canvasGraphics.getObjects().get(canvasGraphics.getObjects().size() - 1));

            // Remove last object from current canvas
            canvasGraphics.removeObject(canvasGraphics.getObjects().size() - 1);
            repaint();
        }
    }

    /**
     * Provides redo functionality by adding the last object from
     * the undoHistory list to the current canvasGraphics list
     */
    public void redo() {
        if (undoHistory.getObjects().size() > 0) {
            // Add last object to current canvas
            canvasGraphics.addObject(undoHistory.getObjects().get(undoHistory.getObjects().size() - 1));

            // Remove last object from undo history
            undoHistory.removeObject(undoHistory.getObjects().size() - 1);
            repaint();
        }
    }

    /**
     * Clears all graphics objects currently in the canvas list
     */
    public void canvasClear() {
        // Clear canvas
        if (canvasGraphics.getObjects().size() > 0) {
            canvasGraphics.getObjects().removeAll(canvasGraphics.getObjects());
        }

        // Clear undo history
        if (undoHistory.getObjects().size() > 0) {
            undoHistory.getObjects().removeAll(undoHistory.getObjects());
        }

        // Update canvas
        repaint();
    }

    /**
     * Resizes the vector canvas (maintaining aspect ratio) when the user resizes the window.
     * @param containerSize
     */
    public void canvasResize(Dimension containerSize) {
        int minEdge = Math.min(containerSize.height, containerSize.width);
        gui.vectorCanvas.setPreferredSize(new Dimension(minEdge - 10,minEdge - 10));

        canvasGraphics.setSize(minEdge - 10);
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
}