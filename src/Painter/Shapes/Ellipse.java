package Painter.Shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import Painter.Points;

/**
 * Ellipse Drawing Logic
 * @author Darren Gebler, James Hassett
 */

public class Ellipse extends Shapes{

    protected Points Origin;
    protected  Points finalPoint;

    /**
     * Ellipse Shape Properties
     * @param start
     * @param colour
     * @param filled
     * @param outlined
     * @param outterColour
     */

    public Ellipse(Points start, Color colour, Boolean filled, Boolean outlined, Color outterColour) {
        super(start, colour, filled, outlined, outterColour);
        this.finalPoint = new Points(start.getX(), start.getY());
        this.Origin = new Points(start.getX(), start.getY());
    }


    /**
     * Returns width of Ellipse
     * @return width
     */
    public int getWidth() {
        return this.getFinal().getX() - this.getStart().getX();
    }

    /**
     * Returns height of Ellipse
     * @return height
     */
    public int getHeight() {
        return this.getFinal().getY() - this.getStart().getY();
    }

    /**
     * Returns initial, mouse pressed, starting Points
     * @return initial x, y Points
     */
    public Points getStart() {
        int x = this.getStart().getX();
        int y = this.getStart().getY();
        Points initPos = new Points(x,y);
        return initPos;
    }

    /**
     * Returns final, mouse released, Points
     * @return final x, y Points
     */

    public Points getFinal() {
        return this.finalPoint;
    }

    /**
     * Sets final Point
     * @param p
     */
    public void setFinalPoint(Points p) {
        this.finalPoint = p;
    }

    /**
     * Drawing ellipse Shape
     * with calculations
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        int x = this.getStart().getX();
        int y = this.getStart().getY();
        int width = this.getWidth();
        int height = this.getHeight();
        if (super.getFilled()){
            g.fillOval(x,y,width,height);
            if (super.getOutlined()){
                g.setColor(super.getOuterColour());
                g.drawOval(x,y,width,height);
            }
        }
        else if (super.getOutlined()) {
            g.setColor(super.getOuterColour());
            g.drawOval(x,y,width,height);
        }
        else {
            g.drawOval(x,y,width, height);
        }
    }

    /**
     * Calculates Ellipse to draw
     * @param p
     */
    public void calcForDraw(Points p) {
        this.getFinal().setX(Math.max(p.getX(), this.Origin.getX()));
        this.getFinal().setY(Math.max(p.getY(), this.Origin.getY()));
        this.getStart().setX(Math.min(p.getX(), this.Origin.getX()));
        this.getStart().setY(Math.min(p.getY(), this.Origin.getX()));
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
