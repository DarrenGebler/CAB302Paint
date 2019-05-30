package Painter.Shapes;

import java.awt.*;

/**
 *  Functions called when drawing
 * @author Darren Gebler, James Hassett
 */

public class ShapesDoPass implements ShapesPass {

    static Graphics2D g;

    public ShapesDoPass(Graphics2D g) {
        this.g = g;
    }

    @Override
    public void pass(Shapes shapes) {
    }

    /**
     * Draw circle when called
     * @param circle
     */
    @Override
    public void pass(Circle circle) {
        circle.draw(g);
    }

    /**
     * Draw line when called
     * @param line
     */
    @Override
    public void pass(Line line) {
        line.draw(g);
    }

    /**
     * Draw plot when called
     * @param plot
     */
    @Override
    public void pass(Plot plot) {
        plot.draw(g);
    }

    /**
     * Draw polygon line when called
     * @param polygonLine
     */
    @Override
    public void pass(PolygonLine polygonLine) {
        polygonLine.draw(g);
    }

    /**
     * Draw rectangle when called
     * @param rectangle
     */
    @Override
    public void pass(Rectangle rectangle) {
        rectangle.draw(g);
    }

    /**
     * Draw ellipse when called
     * @param ellipse
     */
    @Override
    public void pass(Ellipse ellipse){
        ellipse.draw(g);
    }

}
