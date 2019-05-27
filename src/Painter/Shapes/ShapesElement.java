package Painter.Shapes;

public interface ShapesElement {
    void accept(ShapeElementVisitor visitor);
}
