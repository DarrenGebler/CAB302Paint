package Painter.Shapes;

/**
 * Shape Pass through operation
 * @author Darren Gebler, James Hassett
 */

public interface ShapesPass {
    /**
     * Shapes pass
     * @param  shapes
     */
    void pass(Shapes shapes);

    /**
     * Circle Pass
     * @param circle
     */
    void pass(Circle circle);

    /**
     * Ellipse Pass
     * @param ellipse
     */
    void pass(Ellipse ellipse);

    /**
     * Line Pass
     * @param line
     */
    void pass(Line line);

    /**
     * Polygon Line Pass
     * @param polygonLine
     */
    void pass(PolygonLine polygonLine);

    /**
     * Rectangle Pass
     * @param rectangle
     */
    void pass(Rectangle rectangle);

    /**
     * Plot Pass
     * @param plot
     */
    void pass(Plot plot);

}