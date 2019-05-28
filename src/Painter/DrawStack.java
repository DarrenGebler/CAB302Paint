package Painter;

import Painter.Shapes.Shapes;
import java.awt.*;
import java.util.ArrayList;

/**
 * Handles Undo, Redo, Clearing, and niche Drawing Functions
 * @author Darren Gebler, James Hassett
 */

public class DrawStack {
    private ArrayList<Shapes> toDraw;
    private ArrayList<Shapes> undo;

    /**
     * Allocates memory to ArrayLists when Class is called
     */
    public DrawStack() {
        this.toDraw = new ArrayList<Shapes>();
        this.undo = new ArrayList<Shapes>();
    }

    /**
     * Returns shapes to be drawn
     * @return list of Shapes to be drawn
     */
    public ArrayList<Shapes> getToDraw() {
        return this.toDraw;
    }

    /**
     * Adds shapes to toDraw arraylist
     * @param s
     */
    public void addShapes(Shapes s) {
        this.toDraw.add(s);
        this.undo.clear();
    }

    /**
     * Clears arraylist toDraw and undo
     */
    public void Clear() {
        this.toDraw.clear();
        this.undo.clear();
    }

    /**
     * Removes shapes from arraylist toDraw
     * @param s
     */
    public void removeShapes(Shapes s) {
        this.toDraw.remove(s);
    }

    /**
     * Checks if arraylist toDraw contains s
     * @param s
     * @return true if arraylist toDraw contains s
     */
    public boolean Contains(Shapes s) {
        return toDraw.contains(s);
    }

    /**
     * undo function
     */
    public void Undo() {
        if (this.undo.size() > 0) {
            this.toDraw.add(this.undo.get(this.undo.size() - 1));
            this.undo.remove((this.undo.size() -1));
        }
    }

    /**
     * redo function
     */
    public void Redo() {
        if (this.undo.size() > 0) {
            this.undo.add(this.toDraw.get(this.toDraw.size() - 1));
            this.toDraw.remove(this.toDraw.size() - 1);
        }
    }

    /**
     * Draw function
     * @param g
     */
    public void Draw(Graphics2D g) {
        for (Shapes i : this.toDraw) {
            i.draw(g);
        }
    }
}
