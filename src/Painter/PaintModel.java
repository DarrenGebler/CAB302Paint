package Painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Observable;

import Painter.Shapes.Circle;
import Painter.Shapes.Shapes;

/**
 * 
 */

public class PaintModel extends Observable{
    private Circle pointer = new Circle(new Points(0,0), Color.LIGHT_GRAY, new BasicStroke(1), false,false,Color.GRAY);
    private DrawStack drawStack = new DrawStack();
    private String current = "Circle";
    private Color colour = Color.BLACK;
    private Boolean filled = false;
    private Boolean outlined = false;
    private Color outlineColour = Color.BLACK;
    private int strokeWidth = 2;
    private Stroke stroke = new BasicStroke(2,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);


    /**
     *
     * @param s
     */
    public void addShape(Shapes s) {
        drawStack.addShapes(s);
        this.setChanged();
        this.notifyObservers();
    }

    public void Undo() {
        this.drawStack.Undo();
        this.setChanged();
        this.notifyObservers();
    }

    public void Redo() {
        this.drawStack.Redo();
        this.setChanged();
        this.notifyObservers();
    }

    public DrawStack getShapes() {
        return this.drawStack;
    }

    public void changePointer(Points p, int w) {
        this.pointer.setColour(Color.LIGHT_GRAY);
        this.pointer.setStart(p);
        this.pointer.setRadius(w+1);
        this.setChanged();
        this.notifyObservers();
    }

    public Circle getPointer() {
        return this.pointer;
    }

    public void New() {
        this.drawStack.Clear();
        this.setChanged();
        this.notifyObservers();
    }

    public void setCurrent(String s) {
        this.current = s;
    }

    public String getCurrent() {
        return this.current;
    }

    public Color getColour() {
        return this.colour;
    }

    public void setColor(Color colour) {
        this.colour = colour;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * @param strokeWidth
     */
    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    /**
     * @return filled
     */
    public Boolean getFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public Boolean getOutlined() {
        return outlined;
    }

    public void setOutlined(Boolean outlined) {
        this.outlined = outlined;
    }

    public Color getOutlineColour() {
        return outlineColour;
    }

    public void setOutlineColour(Color outlineColour) {
        this.outlineColour = outlineColour;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(int w) {
        this.strokeWidth = w;
        this.stroke = new BasicStroke(w, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    }
}
