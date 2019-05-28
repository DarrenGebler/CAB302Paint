package Painter.Shapes;

import java.awt.*;

/**
 *  Functions called when drawing
 */

public class ShapesDoPass implements ShapesPass {

    static Graphics2D g;

    public ShapesDoPass(Graphics2D g) {
        this.g = g;
    }

    @Override
    public void visit(Shapes shapes) {
    }

    @Override
    public void visit(Circle circle) {
        circle.draw(g);
    }

    @Override
    public void visit(Line line) {
        line.draw(g);
    }

    @Override
    public void visit(Plot plot) {
        plot.draw(g);
    }

    @Override
    public void visit(PolygonLine polygonLine) {
        polygonLine.draw(g);
    }

    @Override
    public void visit(Rectangle rectangle) {
        rectangle.draw(g);
    }

    @Override
    public void visit(Ellipse ellipse){
        ellipse.draw(g);
    }

    @Override
    public void visit(FreeDraw freeDraw) {
        freeDraw.draw(g);
    }
}
