package Painter.Shapes;


import Painter.Points;

import javax.swing.*;
import java.awt.*;

public class DrawShapes {
    public Shapes getShape(String shape, Points start, Color colour, Stroke stroke, boolean filled,
                           int strokeW, boolean outlined, Color outlineColour, JPanel jp) {
        if(shape == null) {
            return null;
        }
        if(shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle(start, colour, stroke, filled, outlined, outlineColour);
        }
        if(shape.equalsIgnoreCase("ELLIPSE")) {
            return new Ellipse(start, colour, stroke, filled, outlined, outlineColour);
        }
        if(shape.equalsIgnoreCase("LINE")) {
            return new Line(start, colour, stroke);
        }
        if(shape.equalsIgnoreCase("PLOT")) {
            return new Plot(start,colour);
        }
        if(shape.equalsIgnoreCase("POLYGONLINE")) {
            return new PolygonLine(start, colour, stroke);
        }
        if(shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(start, colour, stroke, filled, outlined, outlineColour);
        }
        return null;
    }
}
