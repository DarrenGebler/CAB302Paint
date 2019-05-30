package Painter.Shapes;


import Painter.Points;

import javax.swing.*;
import java.awt.*;

public class DrawShapes {
    public Shapes getShape(String shape, Points start, Color colour, boolean filled, boolean outlined, Color outlineColour, JPanel jp) {
        if(shape == null) {
            return null;
        }
        if(shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle(start, colour, filled, outlined, outlineColour);
        }
        if(shape.equalsIgnoreCase("ELLIPSE")) {
            return new Ellipse(start, colour, filled, outlined, outlineColour);
        }
        if(shape.equalsIgnoreCase("LINE")) {
            return new Line(start, colour);
        }
        if(shape.equalsIgnoreCase("PLOT")) {
            return new Plot(start,colour);
        }
        if(shape.equalsIgnoreCase("POLYGONLINE")) {
            return new PolygonLine(start, colour);
        }
        if(shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(start, colour, filled, outlined, outlineColour);
        }
        return null;
    }
}
