package Painter.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Observable;

import Painter.Points;
import Painter.PaintModel;

public abstract class Shapes extends Observable implements ShapesElement{
    private Color colour;
    private Stroke stroke;
    private Points start;
    private Boolean filled = false;
    private Boolean outlined = false;
    private Color outterColor;
    protected Boolean finished = false;


    public Shapes(Points start, Color colour, Stroke stroke, Boolean filled, Boolean outlined, Color outterColor) {
        this.start = start;
        this.colour = colour;
        this.stroke = stroke;
        this.filled = filled;
        this.outlined = outlined;
        this.outterColor = outterColor;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }
    public void addPoint(Points p) {
        return;
    }
    public boolean getFilled() {
        return this.filled;
    }

    public Color getOutterColor() {
        return this.outterColor;
    }

    public void setOutlined() {
        this.outlined = !this.outlined;
    }

    public Boolean getOutlined() {
        return this.outlined;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Stroke getStroke() {
        return this.stroke;
    }

    public Color getColour() {
        return this.colour;
    }

    public void setStart(Points p) {
        this.start = p;
    }

    public Points getStart() {
        return start;
    }

    public void accept(ShapeElementVisitor visitor) {
        this.accept(visitor);
        visitor.visit(this);
    }

    public void addToModel(PaintModel pm) {
        if (!pm.getShapes().Contains(this)) {
            pm.addShape(this);
        }
        else {
            pm.getShapes().removeShapes(this);
            pm.addShape(this);
        }
    }

    public Boolean getFinished() {
        return this.finished;
    }

    public abstract void draw(Graphics2D g);

    public abstract void calcForDraw(Points p);

    public abstract void setFinished();

}
