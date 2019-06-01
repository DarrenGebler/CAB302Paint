package VectorDesign.VectorTools;

import java.awt.*;

/**
 * Extend shape bass class to implement line drawing
 */
public class Line extends Shapes {
    private double x1, y1, x2, y2;

    public Line(double x1, double y1, double x2, double y2, Color color) {
        super(color, null, false);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void preview(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics graphics, int canvasSize) {
        graphics.setColor(getLineColor());
        graphics.drawLine((int)((x1) * canvasSize), (int)((y1) * canvasSize), (int)((x2) * canvasSize), (int)((y2) * canvasSize));
    }
}
