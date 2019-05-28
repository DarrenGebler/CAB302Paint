package Painter.Shapes;

/**
 * Shape Pass acceptance operation
 * @author Darren Gebler, James Hassett
 */

public interface ShapesElement {
    /**
     * @param visitor
     */
    void accept(ShapesPass visitor);
}
