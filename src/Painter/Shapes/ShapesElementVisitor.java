package Painter.Shapes;

public interface ShapesElementVisitor {
    /**
     * @param circle
     */
    void visit(Circle circle);

    /**
     * @param  shapes
     */
    void visit(Shapes shapes);

    /**
     * @param ellipse
     */
    void visit(Ellipse ellipse);

    /**
     * @param line
     */
    void visit(Line line);

    /**
     * @param polygonLine
     */
    void visit(PolygonLine polygonLine);

    /**
     * @param rectangle
     */
    void visit(Rectangle rectangle);


    /**
     * @param freeDraw
     */
    void visit(FreeDraw freeDraw);

    /**
     * @param plot
     */
    void visit(Plot plot);

}