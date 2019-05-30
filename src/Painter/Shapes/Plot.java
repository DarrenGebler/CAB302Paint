package Painter.Shapes;

import Painter.Points;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Plot Drawing Logic
 * @author Darren Gebler, James Hassett
 */

public class Plot extends Shapes{
    private Points end;

    /**
     * Plot shape properties
     * @param start
     * @param colour
     */
    public Plot(Points start, Color colour) {
        super(start,colour);
    }

    /**
     * Drawing plot shape
     * with calculations
     * @param g
     */
    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.drawLine(this.getStart().getX(),this.getStart().getY(), this.getStart().getX(), this.getStart().getY());
    }

    /**
     * Calculates Plot to draw
     * @param p
     */
    public void calcForDraw(Points p) {
        this.end = p;
        this.setChanged();
        this.notifyObservers();
    }

//    private void replaceEnds(Points p) {
//        this.end = p;
//    }

//    public Points getEnd() {
//        return this.end;
//    }

    /**
     * Pass shape to ShapeElement Interface
     * @param shapesPass
     */
    public void accept(ShapesPass shapesPass) {
        shapesPass.pass(this);
    }

    /**
     * Set finished state
     */
    public void setFinished() {
        this.finished = true;
    }
}
