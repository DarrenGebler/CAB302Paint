package Painter.Shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Observable;
import Painter.Points;
import Painter.PaintModel;

/**
 * Shape Properties Defined
 * @author Darren Gebler, James Hassett
 */

public abstract class Shapes extends Observable implements ShapesElement{
    private Color colour;
    private Stroke stroke;
    private Points start;
    private Boolean filled = false;
    private Boolean outlined = false;
    private Color outerColour;
    protected Boolean finished = false;

    /**
     * Assigning Passed Properties Variables to Shape Properties
     * Shapes: Rectangle, Ellipse, Circle
     * @param start
     * @param colour
     * @param stroke
     * @param filled
     * @param outlined
     * @param outerColour
     */
    public Shapes(Points start, Color colour, Stroke stroke, Boolean filled, Boolean outlined, Color outerColour) {
        this.start = start;
        this.colour = colour;
        this.stroke = stroke;
        this.filled = filled;
        this.outlined = outlined;
        this.outerColour = outerColour;
    }

    /**
     * Assigning Passed Properties Variables to Shape Properties
     * Shapes: Line, PolygonLine
     * @param start
     * @param colour
     * @param stroke
     */
    public Shapes(Points start, Color colour, Stroke stroke) {
        this.start = start;
        this.colour = colour;
        this.stroke = stroke;
    }

    /**
     * Assigning Passed Properties Variables to Shape Properties
     * Shapes: Plot
     * @param start
     * @param colour
     */
    public Shapes(Points start, Color colour) {
        this.start = start;
        this.colour = colour;
    }

    /**
     * Set Colour of Line
     * @param colour
     */
    public void setColour(Color colour) {
        this.colour = colour;
    }

    /**
     * Determining if Filled or Not Filled
     * @param filled
     */
    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    /**
     * Adding Points to Shape
     * @param p
     */
    public void addPoint(Points p) {
        return;
    }

    /**
     * @return if Filled Chosen
     */
    public boolean getFilled() {
        return this.filled;
    }

    /**
     *
     * @return Outer colour
     */
    public Color getOuterColour() {
        return this.outerColour;
    }

    /**
     * Changes if Shape is outlined based on button press
     */
    public void setOutlined() {
        this.outlined = !this.outlined;
    }

    /**
     * @return if Outlined Chosen
     */
    public Boolean getOutlined() {
        return this.outlined;
    }

    /**
     * Sets Line Thickness
     * @param stroke
     */
    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    /**
     * @return Stroke thickness
     */
    public Stroke getStroke() {
        return this.stroke;
    }

    /**
     *
     * @return Colour
     */
    public Color getColour() {
        return this.colour;
    }

    /**
     * Set Starting Point
     * @param p
     */
    public void setStart(Points p) {
        this.start = p;
    }

    /**
     *
     * @return Starting Point
     */
    public Points getStart() {
        return start;
    }

    /**
     * Passes Shape to ShapeElement Interface
     * @param shapesPass
     */
    public void accept(ShapesPass shapesPass) {
        this.accept(shapesPass);
        shapesPass.visit(this);
    }

    /**
     * Adds drawn shape to Panel
     * @param pm
     */
    public void addToModel(PaintModel pm) {
        if (!pm.getShapes().Contains(this)) {
            pm.addShape(this);
        }
        else {
            pm.getShapes().removeShapes(this);
            pm.addShape(this);
        }
    }

    /**
     * @return if Finished drawing
     */
    public Boolean getFinished() {
        return this.finished;
    }

    /**
     * Function for drawing shapes
     * @param g
     */
    public abstract void draw(Graphics2D g);

    /**
     * Calculating shape properties for drawing shapes
     * @param p
     */
    public abstract void calcForDraw(Points p);

    /**
     * Function to set finished state
     */
    public abstract void setFinished();

}
