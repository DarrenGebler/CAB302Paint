package Painter.Shapes;

import Painter.Points;
import java.awt.*;
import java.util.ArrayList;

/**
 * Polygon Line Drawing Logic
 * @author Darren Gebler, James Hassett
 */

public class PolygonLine extends Shapes{

    private ArrayList<Integer> xPoints;
    private ArrayList<Integer> yPoints;
    private int numLines;

    /**
     * PolygonLine Shape Properties
     * @param start
     * @param colour
     */

    public PolygonLine(Points start, Color colour) {
        super(start, colour);
        this.xPoints = new ArrayList<>();
        this.yPoints = new ArrayList<>();
        this.numLines = 0;
        this.calcForDraw(start);
    }

    /**
     * Drawing polygon line shape
     * with calculations
     * @param g
     */
    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.drawPolyline(this.box(xPoints), this.box(yPoints), this.numLines);
    }

    /**
     * Calculates polygon line to draw
     * @param p
     */
    public void calcForDraw(Points p ) {
        if (this.numLines > 1) {
            this.changePoint(p);
        }
        else {
            this.addPoint(p);
        }
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Changes point at which to draw from to the cursor position
     * @param p
     */
    private void changePoint(Points p) {
        this.xPoints.set(this.numLines - 1, p.getX());
        this.yPoints.set(this.numLines - 1, p.getY());
    }

    /**
     * Stores x Points
     * @return x Points from box variable
     */
    public int[] getXPoints() {
        return box(this.xPoints);
    }

    /**
     * Stores y Points
     * @return y Points from box variable
     */
    public int[] getYPoints() {
        return box(this.yPoints);
    }

    /**
     * Returns all x Points
     * @return x Points
     */
    public ArrayList<Integer> getXPointsList() {
        return this.xPoints;
    }

    /**
     * Returns all y Points
     * @return y Points
     */
    public ArrayList<Integer> getyPointsList() {
        return this.yPoints;
    }

    /**
     * Adding x and y Points
     * Updates number of lines drawn
     * @param p
     */
    public void addPoint(Points p) {
        this.xPoints.add(p.getX());
        this.yPoints.add(p.getY());
        this.numLines++;
    }

    /**
     * Stores all points
     * Line number is index
     * @param list
     * @return returns x, y Points
     */
    public int[] box(ArrayList<Integer> list) {
        int[] ret = new int[this.numLines];
        for (int i = 0; i < list.size(); i++ ) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    /**
     * Returns number of lines drawn
     * @return numLines
     */
    public int getNumLines() {
        return this.numLines - 1;
    }

    /**
     * Pass shape to ShapeElement Interface
     * @param shapesPass
     */
    public void accept(ShapesPass shapesPass) {
        shapesPass.visit(this);
    }

    /**
     * Set finished state
     */
    public void setFinished() {
    }
}
