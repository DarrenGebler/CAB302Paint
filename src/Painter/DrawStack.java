package Painter;

import Painter.Shapes.Shapes;

import java.awt.*;
import java.util.ArrayList;

public class DrawStack {
    private ArrayList<Shapes> toDraw;
    private ArrayList<Shapes> undo;

    public DrawStack() {
        this.toDraw = new ArrayList<Shapes>();
        this.undo = new ArrayList<Shapes>();
    }

    public ArrayList<Shapes> getToDraw() {
        return this.toDraw;
    }

    public void addShapes(Shapes s) {
        this.toDraw.add(s);
        this.undo.clear();
    }

    public void Clear() {
        this.toDraw.clear();
        this.undo.clear();
    }

    public void removeShapes(Shapes s) {
        this.toDraw.remove(s);
    }

    public boolean Contains(Shapes s) {
        return toDraw.contains(s);
    }

    public void Undo() {
        if (this.undo.size() > 0) {
            this.toDraw.add(this.undo.get(this.undo.size() - 1));
            this.undo.remove((this.undo.size() -1));
        }
    }

    public void Redo() {
        if (this.undo.size() > 0) {
            this.undo.add(this.toDraw.get(this.toDraw.size() - 1));
            this.toDraw.remove(this.toDraw.size() - 1);
        }
    }

    public void Draw(Graphics2D g) {
        for (Shapes i : this.toDraw) {
            i.draw(g);
        }
    }
}
