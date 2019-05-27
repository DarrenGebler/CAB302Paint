package Painter.Shapes;

import Painter.Points;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Shapes{
    private int radius;
    protected Points Origin;
    protected  Points finalPoint;

    public Ellipse(Points start, Color colour, Stroke stroke, Boolean filled, Boolean outlined, Color outterColour) {
        super(start, colour, stroke, filled, outlined, outterColour);
        this.finalPoint = new Points(start.getX(), start.getY());
        this.Origin = new Points(start.getX(), start.getY());
    }

//    public int getRadius() {
//        return this.radius;
//    }
//
//    public void setRadius(int radius) {
//        this.radius = radius;
//    }

    public int getWidth() {
        return this.getFinal().getX() - this.getStart().getX();
    }

    public int getHeight() {
        return this.getFinal().getY() - this.getStart().getY();
    }

    public Points getStart() {
        int x = this.getStart().getX();
        int y = this.getStart().getY();
        Points initPos = new Points(x,y);
        return initPos;
    }

    public Points getFinal() {
        return this.finalPoint;
    }

    public void setFinalPoint(Points p) {
        this.finalPoint = p;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setStroke(this.getStroke());
        g.setColor(this.getColour());
        int x = this.getStart().getX();
        int y = this.getStart().getY();
        int width = this.getWidth();
        int height = this.getHeight();
        if (super.getFilled()){
            g.fillOval(x,y,width,height);
            if (super.getOutlined()){
                g.setColor(super.getOutterColor());
                g.drawOval(x,y,width,height);
            }
        }
        else if (super.getOutlined()) {
            g.setColor(super.getOutterColor());
            g.drawOval(x,y,width,height);
        }
        else {
            g.drawOval(x,y,width, height);
        }
    }

    public void calcForDraw(Points p) {
        this.getFinal().setX(Math.max(p.getX(), this.Origin.getX()));
        this.getFinal().setY(Math.max(p.getY(), this.Origin.getY()));
        this.getStart().setX(Math.min(p.getX(), this.Origin.getX()));
        this.getStart().setY(Math.min(p.getY(), this.Origin.getX()));
    }

    public void accept(ShapesElementVisitor visitor) {
        visitor.visit(this);
    }

    public void setFinished() {
        this.finished = true;
    }

}
