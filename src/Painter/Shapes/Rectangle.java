package Painter.Shapes;

import Painter.Points;

import java.awt.*;

public class Rectangle extends Shapes{
    protected Points Origin;
    protected Points finalPoint;
    protected int h;
    protected int w;

    public Rectangle(Points start, Color colour, Stroke stroke, Boolean filled, Boolean outlined, Color outerColour) {
        super(start,colour,stroke,filled,outlined,outerColour);
        this.Origin = new Points(start.getX(), start.getY());
        this.finalPoint = new Points(start.getX(), start.getY());
    }

    public int getWidth() {
        return this.getFinalPoint().getX() - this.getStart().getX();
    }

    public int getHeight() {
        return this.getFinalPoint().getY() - this.getStart().getY();
    }

    public Points getFinalPoint() {
        return this.finalPoint;
    }

    public void setFinalPoint(Points p) {
        this.finalPoint = p;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.setStroke(this.getStroke());
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

    public void calcForDraw(Points p) {
        this.getFinalPoint().setX(Math.max(p.getX(), this.Origin.getX()));
        this.getFinalPoint().setY(Math.max(p.getY(), this.Origin.getY()));
        this.getStart().setX(Math.min(p.getX(), this.Origin.getX()));
        this.getStart().setY(Math.min(p.getY(), this.Origin.getY()));
    }

    public void accept(ShapesPass shapesPass) {
        shapesPass.visit(this);
    }

    public void setFinished() {
        this.finished = true;
    }
}
