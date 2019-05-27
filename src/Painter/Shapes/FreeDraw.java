package Painter.Shapes;

import Painter.Points;

import java.awt.*;
import java.util.ArrayList;

public class FreeDraw extends Shapes {
    ArrayList<Points> points;

    public FreeDraw(Points start, Color colour, Stroke stroke) {
        super(start, colour, stroke);
        points = new ArrayList<Points>();
        points.add(start);
    }

    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.setStroke(this.getStroke());
        for (int i =0; i < points.size() - 1; i++ ) {
            Points pIni = points.get(i);
            Points pFin = points.get(i+1);
            g.drawLine(pIni.getX(), pIni.getY(),pFin.getX(), pFin.getY());
        }
    }

    public void calcForDraw(Points p ) {
        points.add(p);
    }

    public void accept(ShapesElementVisitor visitor) {
        visitor.visit(this);
    }

    public void setFinished() {
        this.finished = true;
    }
}
