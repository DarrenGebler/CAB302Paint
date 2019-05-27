package Painter.Shapes;

import Painter.Points;
import java.awt.Color;
import java.awt.Graphics2D;

public class Plot extends Shapes{
    private Points end;

    public Plot(Points start, Color colour) {
        super(start,colour);
    }

    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.drawLine(this.getStart().getX(),this.getStart().getY(), this.getStart().getX(), this.getStart().getY());
    }

    public void calcForDraw(Points p) {
        this.replaceEnds(p);
        this.setChanged();
        this.notifyObservers();
    }

    private void replaceEnds(Points p) {
        this.end = p;
    }

    public Points getEnd() {
        return this.end;
    }

    public void accept(ShapesElementVisitor visitor) {
        visitor.visit(this);
    }

    public void setFinished() {
        this.finished = true;
    }
}
