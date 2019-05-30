package Painter.Shapes;

import Painter.Points;
import java.awt.*;

/**
 * Line Drawing Logic
 * @author Darren Gebler, James Hassett
 */

public class Line extends Shapes {
    private Points end;

    /**
     * Line shape properties
     * @param start
     * @param colour
     */
    public Line(Points start, Color colour) {
        super(start, colour);
    }

    /**
     * Drawing line shape
     * with calculations
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.drawLine(this.getStart().getX(), this.getStart().getY(), this.end.getX(), this.end.getY());
    }

    /**
     * Calculates line to draw
     * @param p
     */
    @Override
    public void calcForDraw(Points p) {
        this.replaceEnds(p);
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Function to replace ends of line
     * Used to move line with mouse when mouse is being held down
     * @param p
     */
    public void replaceEnds(Points p ) {
        this.end = p;
    }

    /**
     * Returns the final point when mouse is released
     * @return end x, y Points
     */
    public Points getEnd() {
        return this.end;
    }

    /**
     * Pass shape to ShapeElement Interface
     * @param shapesPass
     */
    public void accept(ShapesPass shapesPass) {
        shapesPass.pass(this);
    }

    /**
     * Sets finished state
     */
    public void setFinished() {
        this.finished = true;
    }
}
