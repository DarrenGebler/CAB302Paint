package VectorDesign.VectorTools;

import java.awt.*;

/**
 * Extend shape bass class to implement line drawing
 */
public class Line extends Shapes {
    // Store coordinates to draw the line
    private double x1, y1, x2, y2;

    /**
     * Creates a new line object
     * @param x1 Start x
     * @param y1 Start y
     * @param x2 End x
     * @param y2 End y
     * @param color Line color
     */
    public Line(double x1, double y1, double x2, double y2, Color color) {
        super(color, null);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Resizes the line while the user draws to enable a preview
     * @param x2 drag pos x
     * @param y2 drag pos y
     */
    @Override
    public void preview(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;
    }


    /**
     * Draws the line to the graphics canvas
     * @param graphics graphics panel to draw to
     * @param canvasSize size of canvas in pixels, used for scaling the graphics
     */
    @Override
    public void draw(Graphics graphics, int canvasSize) {
        graphics.setColor(getLineColor());
        graphics.drawLine((int)((x1) * canvasSize), (int)((y1) * canvasSize), (int)((x2) * canvasSize), (int)((y2) * canvasSize));
    }

    /**
     * Creates a string to save the object to a VEC formatted file
     * @return output The vec string
     */
    public String toVec() {
        String output = "PEN #" + Integer.toHexString(getLineColor().getRGB()).substring(2) + "\n";
        output += "LINE " + x1 + " " + y1 + " " + x2 + " " + y2 + "\n";

        return output;
    }

    /**
     * Creates a string for the tool name
     * @return Tool name "Line"
     */
    public  String toString() {
        return "Line";
    }

    /**
     * Used only for polygon, return false
     * @param x2 x position of new vertex
     * @param y2 y position of new vertex
     * @return false
     */
    @Override
    public boolean addVertex(double x2, double y2){
        return false;
    }
}
