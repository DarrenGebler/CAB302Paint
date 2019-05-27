package Painter.Shapes;

public interface ShapesElementVisitor {
    /**
     * @param circle
     *          to visit
     */
    void visit(Circle circle);

    /**
     * @param  shapes
     *          shape to visit
     */
    void visit(Shapes shapes);

    /**
     * @param ellipse
     *            to visit
     */
    void visit(Ellipse ellipse);

    /**
     * @param line
     *            to visit
     */
    void visit(Line line);

    /**
     * @param polygonLine
     */
    void visit(PolygonLine polygonLine);

//    /**
//     * @param polygon
//     *            to visit
//     */
//    void visit(Polygon polygon);

//    /**
//     * @param polyline
//     *            to visit
//     */
//    void visit(Polyline polyline);

    /**
     * @param rectangle
     *            to visit
     */
    void visit(Rectangle rectangle);


    /**
     * @param freeDraw
     *            to visit
     */
    void visit(FreeDraw freeDraw);

    /**
     * @param plot
     */
    void visit(Plot plot);

}