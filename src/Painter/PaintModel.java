package Painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;

import Painter.Shapes.Circle;
import Painter.Shapes.Shapes;

/**
 *
 */

public class PaintModel extends Observable{
    private Circle pointer = new Circle(new Points(0,0), Color.LIGHT_GRAY, false,false,Color.GRAY);
    private DrawStack drawStack = new DrawStack();
    private String current = "Circle";
    private Color colour = Color.BLACK;
    private Boolean filled = false;
    private Boolean outlined = false;
    private Color outlineColour = Color.BLACK;



    /**
     *
     * @param s
     */
    public void addShape(Shapes s) {
        drawStack.addShapes(s);
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Calls undo function
     */
    public void Undo() {
        this.drawStack.Undo();
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Calls redo function
     */
    public void Redo() {
        this.drawStack.Redo();
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Returns drawStack variables
     * @return drawStack
     */
    public DrawStack getShapes() {
        return this.drawStack;
    }

    /**
     * Change drawing pointer
     * @param p
     * @param w
     */
    public void changePointer(Points p, int w) {
        this.pointer.setColour(Color.LIGHT_GRAY);
        this.pointer.setStart(p);
        this.pointer.setRadius(w+1);
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Returns pointer
     * @return pointer
     */
    public Circle getPointer() {
        return this.pointer;
    }

    /**
     * Clears drawing canvas
     */
    public void New() {
        this.drawStack.Clear();
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Set current shape type
     * @param s
     */
    public void setCurrent(String s) {
        this.current = s;
    }

    /**
     * Returns current shape type
     * @return current shape
     */
    public String getCurrent() {
        return this.current;
    }

    /**
     * Returns current colour
     * @return colour
     */
    public Color getColour() {
        return this.colour;
    }

    /**
     * Sets current colour
     * @param colour
     */
    public void setColor(Color colour) {
        this.colour = colour;
    }

    /**
     * Returns filled state
     * @return filled true/false
     */
    public Boolean getFilled() {
        return filled;
    }

    /**
     * Sets filled state
     * @param filled
     */
    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    /**
     * Returns outlined state
     * @return outlined true/false
     */
    public Boolean getOutlined() {
        return outlined;
    }

    /**
     * Sets outlined state
     * @param outlined
     */
    public void setOutlined(Boolean outlined) {
        this.outlined = outlined;
    }

    /**
     * Returns outline colour
     * @return outline colour
     */
    public Color getOutlineColour() {
        return outlineColour;
    }

    /**
     * Sets outline colour
     * @param outlineColour
     */
    public void setOutlineColour(Color outlineColour) {
        this.outlineColour = outlineColour;
    }
}
