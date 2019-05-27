package Painter.Shapes;

import Painter.Points;

import java.awt.*;
import java.util.ArrayList;

public class PolygonLine extends Shapes{

    private ArrayList<Integer> xPoints;
    private ArrayList<Integer> yPoints;
    private int numLines;

    public PolygonLine(Points start, Color colour, Stroke stroke) {
        super(start, colour, stroke);
        this.xPoints = new ArrayList<>();
        this.yPoints = new ArrayList<>();
        this.numLines = 0;
        this.calcForDraw(start);
    }

    public void draw(Graphics2D g) {
        g.setColor(this.getColour());
        g.setStroke(this.getStroke());
        g.drawPolyline(this.box(xPoints), this.box(yPoints), this.numLines);
    }

    public void calcForDraw(Points p ) {
        if (this.numLines > 1) {
            this.changePoint(p);
        }
        else {
            this.addPoint(p);
        }
        this.setChanged();
        this.notifyObservers();
    }

    private void changePoint(Points p) {
        this.xPoints.set(this.numLines - 1, p.getX());
        this.yPoints.set(this.numLines - 1, p.getY());
    }

    public int[] getXPoints() {
        return box(this.xPoints);
    }

    public int[] getYPoints() {
        return box(this.yPoints);
    }

    public ArrayList<Integer> getXPointsList() {
        return this.xPoints;
    }

    public ArrayList<Integer> getyPointsList() {
        return this.yPoints;
    }

    public void addPoint(Points p) {
        this.xPoints.add(p.getX());
        this.yPoints.add(p.getY());
        this.numLines++;
    }

    public int[] box(ArrayList<Integer> list) {
        int[] ret = new int[this.numLines];
        for (int i = 0; i < list.size(); i++ ) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int getNumLines() {
        return this.numLines - 1;
    }

    public void accept(ShapesElementVisitor visitor) {
        visitor.visit(this);
    }

    public void setFinished() {
    }
}
