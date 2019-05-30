package Painter.Shapes;

import Painter.Points;
import java.awt.*;

/**
 * Rectangle Drawing Logic
 * @author Darren Gebler, James Hassett
 */

public class Rectangle extends Shapes{
    protected Points Origin;
    protected Points finalPoint;
    protected int h;
    protected int w;

    /**
     * Rectangle Shape properties
     * @param start
     * @param colour
     * @param filled
     * @param outlined
     * @param outerColour
     */
    public Rectangle(Points start, Color colour, Boolean filled, Boolean outlined, Color outerColour) {
        super(start,colour,filled,outlined,outerColour);
        this.Origin = new Points(start.getX(), start.getY());
        this.finalPoint = new Points(start.getX(), start.getY());
    }

    /**
     * Returns width of rectangle
     * @return width
     */
    public int getWidth() {
        return this.getFinalPoint().getX() - this.getStart().getX();
    }

    /**
     * Returns height of rectangle
     * @return height
     */
    public int getHeight() {
        return this.getFinalPoint().getY() - this.getStart().getY();
    }

    /**
     * Return final position where mouse is released
     * @return final x, y Points
     */
    public Points getFinalPoint() {
        return this.finalPoint;
    }

    /**
     * Sets final x, y Points
     * @param p
     */
    public void setFinalPoint(Points p) {
        this.finalPoint = p;
    }

    /**
     * Drawing rectangle shape
     * with calculations
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        int x = this.getStart().getX();
        int y = this.getStart().getY();
        int w = this.getWidth();
        int h = this.getHeight();
        if (super.getFilled()) {
            g.fillRect(x,y,w,h);
            if (super.getOutlined()) {
                g.setColor(super.getOuterColour());
                g.drawRect(x,y,w,h);
            }
        }
        else if (super.getOutlined()) {
            g.setColor(super.getOuterColour());
            g.drawRect(x,y,w,h);
        }
        else {
            g.drawRect(x,y,w,h);
        }
    }

    /**
     * Calculates Rectangle to draw
     * @param p
     */
    public void calcForDraw(Points p) {
        this.getFinalPoint().setX(Math.max(p.getX(), this.Origin.getX()));
        this.getFinalPoint().setY(Math.max(p.getY(), this.Origin.getY()));
        this.getStart().setX(Math.min(p.getX(), this.Origin.getX()));
        this.getStart().setY(Math.min(p.getY(), this.Origin.getY()));
    }

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
