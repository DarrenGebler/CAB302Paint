package VectorDesign.VectorTools;

import java.awt.*;

/**
 * Generic class for vector tool classes to extend
 */
public abstract class Shapes {
    private Color lineColor, fillColor;
    private boolean fill;

    /**
     * Class constructor for all shapes to extend and override upon
     * @param lineColor color of line to draw shape
     * @param fillColor color of fill to draw shape
     * @param fill whether or not the fill color should be used when drawing shape
     */
    Shapes(Color lineColor, Color fillColor, boolean fill)
    {
        this.lineColor = lineColor;
        this.fillColor = fillColor;
        this.fill = fill;
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
     * Returns whether or not the shape is filled
     * @return
     */
    boolean isFilled() {
        return fill;
    }

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
