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
    void visit(Shapes shapes);

    /**
     * Circle Pass
     * @param circle
     */
    void visit(Circle circle);

    /**
     * Ellipse Pass
     * @param ellipse
     */
    void visit(Ellipse ellipse);

    /**
     * Line Pass
     * @param line
     */
    void visit(Line line);

    /**
     * Polygon Line Pass
     * @param polygonLine
     */
    void visit(PolygonLine polygonLine);

    /**
     * Rectangle Pass
     * @param rectangle
     */
    void visit(Rectangle rectangle);


    /**
     * Free Draw Pass
     * @param freeDraw
     */
    void visit(FreeDraw freeDraw);

    /**
     * Plot Pass
     * @param plot
     */
    void visit(Plot plot);

}