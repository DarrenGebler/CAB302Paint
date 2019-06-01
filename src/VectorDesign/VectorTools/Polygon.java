package VectorDesign.VectorTools;

import java.awt.*;
import java.util.ArrayList;

/**
 * Extend shape bass class to implement polygon drawing
 */
public class Polygon extends Shapes {
    // Store coordinates to draw the polygon
    private ArrayList<Double> xPoints;
    private ArrayList<Double> yPoints;
    private boolean finished;

    /**
     * Creates a new polygon object
     * @param xValues list of x values of vertices
     * @param yValues list of y values of vertices
     * @param lineColor color of polygon outline
     * @param fillColor color of polygon fill
     */
    public Polygon(double[] xValues, double[] yValues, Color lineColor, Color fillColor) {
        super(lineColor, fillColor);
        finished = true;
        xPoints = new ArrayList<>();
        yPoints = new ArrayList<>();

        for (double x : xValues) {
            xPoints.add(x);
        }

        for (double y : yValues) {
            yPoints.add(y);
        }
    }

    /**
     * Adds a vertex to the polygon
     * @param x2 x position of new vertex
     * @param y2 y position of new vertex
     * @return true if the new vertex closes the polygon
     */
    public boolean addVertex(double x2, double y2) {
        finished = false;
        if ((x2 < xPoints.get(0) + 0.03 && x2 > xPoints.get(0) - 0.03)
                && (y2 < yPoints.get(0) + 0.03 && y2 > yPoints.get(0) - 0.03)) {
            // Remove last point as it will be completed automatically
            xPoints.remove(xPoints.size() - 1);
            yPoints.remove(yPoints.size() - 1);
            finished = true;

            return true;
        } else {
            xPoints.add(x2);
            yPoints.add(y2);

            return false;
        }
    }

    /**
     * Update the position of the preview while the user moves the mouse
     * @param x2 move pos x
     * @param y2 move pos y
     */
    @Override
    public void preview(double x2, double y2) {
        xPoints.set(xPoints.size() - 1, x2);
        yPoints.set(yPoints.size() - 1, y2);
    }


    /**
     * Draws the polygon to the graphics canvas
     * Handles drawing a line as a preview the next vertex position
     * @param graphics graphics panel to draw to
     * @param canvasSize size of canvas in pixels, used for scaling the graphics
     */
    @Override
    public void draw(Graphics graphics, int canvasSize) {
        if (finished) {
            int[] xValues = new int[xPoints.size()];
            int[] yValues = new int[yPoints.size()];

            for (int i=0; i<xPoints.size(); i++) {
                xValues[i] = (int) (xPoints.get(i) * canvasSize);
                yValues[i] = (int) (yPoints.get(i) * canvasSize);
            }

            // Fill the polygon if there is a color
            if (getFillColor() != null) {
                graphics.setColor(getFillColor());
                graphics.fillPolygon(xValues, yValues, xValues.length);
            }

            // Draw final polygon
            graphics.setColor(getLineColor());
            graphics.drawPolygon(xValues, yValues, xValues.length);
        } else {
            // Use a line to preview the polygon vertex
            graphics.setColor(getLineColor());
            for (int i=0; i<xPoints.size()-1; i++) {
                graphics.drawLine((int) (xPoints.get(i) * canvasSize), (int) (yPoints.get(i) * canvasSize),
                        (int) (xPoints.get(i+1) * canvasSize), (int) (yPoints.get(i+1) * canvasSize));
            }
        }
    }

    /**
     * Creates a string to save the object to a VEC formatted file
     * @return output The vec string
     */
    public String toVec() {
        String output = toVecColor();
        output += "POLYGON";

        for (int i=0; i < xPoints.size(); i++) {
            output += " " + xPoints.get(i) + " " + yPoints.get(i);
        }

        output += "\n";

        return output;
    }
}
