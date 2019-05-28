package Painter.Shapes;

import java.awt.*;

public class ShapesElementDoVisitor implements ShapesElementVisitor {

    static Graphics2D g;

    public ShapesElementDoVisitor(Graphics2D g) {
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
