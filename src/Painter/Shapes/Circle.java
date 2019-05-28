package Painter.Shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import Painter.Points;

/**
 * Circle Drawing Logic
 * @author Darren Gebler, James Hassett
 */

public class Circle extends Shapes{
    private int radius;

    /**
     * Circle Shape Properties
     * @param start
     * @param colour
     * @param stroke
     * @param filled
     */
    public Circle(Points start, Color colour, Stroke stroke, Boolean filled, Boolean outlined, Color outlineColor) {
        super(start, colour, stroke, filled, outlined, outlineColor);
        this.radius = 0;
    }

    /**
     * Returns radius of Circle
     * @return radius of the circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the new radius of the circle
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Calculate the radius of the circle
     * @param x coordinate
     * @param y coordinate
     */
    public void calculateRadius(int x, int y) {
        this.radius = (int) Math
                .sqrt(Math.pow(this.getStart().getX() - x, 2) + Math.pow(this.getStart().getY() - y, 2));
    }

    /**
     * @return return diameter of circle
     */
    public int getWidth() {
        return this.radius * 2;
    }

    /**
     * @return top left Points of circle
     */
    public Points getLeftCorner() {
        int x = this.getStart().getX() - this.radius;
        int y = this.getStart().getY() - this.radius;
        Points topleft = new Points(x, y);
        return topleft;
    }

    /**
     * Drawing circle shape
     * with calculations
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {

        g.setColor(this.getColour());
        g.setStroke(this.getStroke());
        int x = this.getLeftCorner().getX();
        int y = this.getLeftCorner().getY();
        int width = this.getWidth();
        if (super.getFilled()) {
            g.fillOval(x, y, width, width);
            if (super.getOutlined()) {
                g.setColor(super.getOuterColour());
                g.drawOval(x, y, width, width);
            }
        } else if (super.getOutlined()) {
            g.setColor(super.getOuterColour());
            g.drawOval(x, y, width, width);
        } else {
            g.drawOval(x, y, width, width);
        }

    }

    /**
     * Calculates the circle to draw
     * @param p
     */
    @Override
    public void calcForDraw(Points p) {
        this.calculateRadius(p.getX(), p.getY());
        this.setChanged();
        this.notifyObservers();

    }

    /**
     * Pass Shape to ShapeElement Interface
     * @param shapesPass
     */
    @Override
    public void accept(ShapesPass shapesPass) {
        shapesPass.visit(this);
    }

    /**
     * Set finished state
     */
    @Override
    public void setFinished() {
        this.finished = true;

    }

}
