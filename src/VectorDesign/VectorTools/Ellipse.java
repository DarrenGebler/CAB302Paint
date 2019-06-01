package VectorDesign.VectorTools;

import java.awt.*;

/**
 * Extend shape bass class to implement line drawing
 */
public class Ellipse extends Shapes {
    // Store coordinates to draw the ellipse
    private double x1, y1, x2, y2;
    private double width, height;

    /**
     * Creates a new ellipse object
     * @param x1 Start x
     * @param y1 Start y
     * @param x2 End x
     * @param y2 End y
     * @param lineColor Line color
     * @param fillColor Fill Color
     */
    public Ellipse(double x1, double y1, double x2, double y2, Color lineColor, Color fillColor) {
        super(lineColor, fillColor);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.width = Math.abs(x1 - x2);
        this.height = Math.abs(y1 - y2);
    }

    /**
     * Creates a string to save the object to a VEC formatted file
     * @return output The vec string
     */
    public String toVec() {
        String output = toVecColor();
        output += "ELLIPSE " + x1 + " " + y1 + " " + x2 + " " + y2 + "\n";

        return output;
    }

    /**
     * Resizes the ellipse while the user draws to enable a preview
     * @param x2 drag pos x
     * @param y2 drag pos y
     */
    @Override
    public void preview(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;

        this.width = Math.abs(x2 - x1);
        this.height = Math.abs(y2 - y1);
    }


    /**
     * Draws the ellipse to the graphics canvas
     * @param graphics graphics panel to draw to
     * @param canvasSize size of canvas in pixels, used for scaling the graphics
     */
    @Override
    public void draw(Graphics graphics, int canvasSize) {
        double x = Math.min(x1, x2) * canvasSize;
        double y = Math.min(y1, y2) * canvasSize;

        if (getFillColor() != null) {
            graphics.setColor(getFillColor());
            graphics.fillOval((int) x, (int) y, (int) (width * canvasSize), (int) (height * canvasSize));
        }

        graphics.setColor(getLineColor());
        graphics.drawOval((int) x, (int) y, (int) (width * canvasSize), (int) (height * canvasSize));
    }
}
