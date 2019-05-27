package Painter.Shapes;

public interface ShapesElement {
    void accept(ShapesElementVisitor visitor);
}
