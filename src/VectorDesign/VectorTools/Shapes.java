package VectorDesign.VectorTools;

import java.awt.*;

/**
 * Generic class for vector tool classes to extend
 */
public abstract class Shapes {
    private Color lineColor, fillColor;

    /**
     * Class constructor for all shapes to extend and override upon
     * @param lineColor color of line to draw shape
     * @param fillColor color of fill to draw shape
     * @param fill whether or not the fill color should be used when drawing shape
     */
    Shapes(Color lineColor, Color fillColor)
    {
        this.lineColor = lineColor;
        this.fillColor = fillColor;
    }

    /**
     * Returns line color of the shape
     * @return lineColor
     */
    Color getLineColor() {
        return lineColor;
    }

    /**
     * Returns the fill color of the shape
     * @return fillColor
     */
    Color getFillColor() {
        return fillColor;
    }

    /**
     * Used for objects that can take a fill color
     * Sets the pen color and then either sets the fill color or removes it
     * @return output The vec formatted output
     */
    String toVecColor() {
        String output = "PEN #" + Integer.toHexString(getLineColor().getRGB()).substring(2) + "\n";

        if (getFillColor() != null) {
            output += "FILL #" + Integer.toHexString(getFillColor().getRGB()).substring(2) + "\n";
        } else {
            output += "FILL OFF\n";
        }

        return output;
    }

    /**
     * Creates a string to save the object to a VEC formatted file
     * @return
     */
    public abstract String toVec();

    /**
     * Used exclusively for polygon creation, add's a vertex and closes polygon if the new vertex is
     * close to the starting point
     * @param x2 x position of new vertex
     * @param y2 y position of new vertex
     * @return true if polygon is closed as a result of adding point
     */
    public abstract boolean addVertex(double x2, double y2);

    /**
     * Allows resizing and preview of an object being drawn by changing the end coordinates
     * @param x2
     * @param y2
     */
    public abstract void preview(double x2, double y2);

    /**
     * Base abstract function for shape drawing
     * @param graphics graphics panel to draw to
     * @param canvasSize size of canvas in pixels, used for scaling the graphics
     */
    public abstract void draw(Graphics graphics, int canvasSize);
}
