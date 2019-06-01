package VectorDesign.VectorTools;

import java.awt.*;

/**
 * Extend shape bass class to implement line drawing
 */
public class Plot extends Shapes {
    // Store coordinates to draw the plot
    private double x, y;

    /**
     * Creates a new plot object
     * @param x Start x
     * @param y Start y
     * @param color plot color
     */
    public Plot(double x, double y, Color color) {
        super(color, null);
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a string to save the object to a VEC formatted file
     * @return output The vec string
     */
    public String toVec() {
        String output = "PEN #" + Integer.toHexString(getLineColor().getRGB()).substring(2) + "\n";
        output += "PLOT " + x + " " + y + "\n";

        return output;
    }

    /**
     * Move the plot to the new position
     * @param x drag pos x
     * @param y drag pos y
     */
    @Override
    public void preview(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Draws the plot to the graphics canvas
     * @param graphics graphics panel to draw to
     * @param canvasSize size of canvas in pixels, used for scaling the graphics
     */
    @Override
    public void draw(Graphics graphics, int canvasSize) {
        graphics.setColor(getLineColor());
        graphics.drawLine((int)((x) * canvasSize), (int)((y) * canvasSize), (int)((x) * canvasSize), (int)((y) * canvasSize));
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
