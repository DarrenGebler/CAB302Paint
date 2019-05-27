package Painter.Shapes;

import Painter.Points;
import java.awt.*;

public class Line extends Shapes {
    private Points end;

    public Line(Points start, Color colour, Stroke stroke) {
        super(start, colour, stroke);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.setStroke(this.getStroke());
        g.drawLine(this.getStart().getX(), this.getStart().getY(), this.end.getX(), this.end.getY());
    }

    @Override
    public void calcForDraw(Points p) {
        this.replaceEnds(p);
        this.setChanged();
        this.notifyObservers();
    }

    public void replaceEnds(Points p ) {
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
