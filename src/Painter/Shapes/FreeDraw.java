package Painter.Shapes;

import Painter.Points;

import java.awt.*;
import java.util.ArrayList;

/**
 * Free Drawing Logic
 * @author Darren Gebler, James Hassett
 */

public class FreeDraw extends Shapes {
    ArrayList<Points> points;

    /**
     * Free draw shape properties
     * @param start
     * @param colour
     * @param stroke
     */
    public FreeDraw(Points start, Color colour, Stroke stroke) {
        super(start, colour, stroke);
        points = new ArrayList<Points>();
        points.add(start);
    }

    /**
     * Drawing free draw shape
     * with calculations
     * @param g
     */
    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.setStroke(this.getStroke());
        for (int i =0; i < points.size() - 1; i++ ) {
            Points pIni = points.get(i);
            Points pFin = points.get(i+1);
            g.drawLine(pIni.getX(), pIni.getY(),pFin.getX(), pFin.getY());
        }
    }

    /**
     * Calculates points to draw
     * @param p
     */
    public void calcForDraw(Points p ) {
        points.add(p);
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
        this.finished = true;
    }
}
