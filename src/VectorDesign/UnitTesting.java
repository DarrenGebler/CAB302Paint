package VectorDesign;
import VectorDesign.VectorTools.*;
import VectorDesign.VectorTools.Polygon;
import VectorDesign.VectorTools.Rectangle;
import org.junit.jupiter.api.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;


public class UnitTesting {

    private Shapes shapes;
    private Line line;
    private Ellipse ellipse;
    private Plot plot;
    private Polygon polygon;
    private Rectangle rectangle;
    private GraphicsContainer graphicsContainer;
    private CanvasDrawing canvasDrawing;
    private GUI gui;
    private Tools tools;
    private FileDrawing fileDrawing;
    private UndoGUI undoGUI;



    @BeforeEach
    void setUP() {
        shapes = null;
        line = null;
        ellipse = null;
        plot = null;
        polygon = null;
        rectangle = null;
        graphicsContainer = null;
        fileDrawing = null;
        undoGUI = null;
    }

    @Test
    void testLineConstruction() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color colour = Color.BLACK;

        line = new Line(x1,y1,x2,y2,colour);
    }

    @Test
    void testLinetoVec() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color colour = Color.BLACK;

        line = new Line(x1,y1,x2,y2,colour);

        String expected = "PEN #000000\nLINE 0.55 0.33 0.44 0.22\n";

        assertEquals(expected, line.toVec());
    }

    @Test
    void testLinetoString() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color colour = Color.BLACK;

        line = new Line(x1,y1,x2,y2,colour);

        String expected = "Line";

        assertEquals(expected,line.toString());
    }

    @Test
    void testEllipseConstruction() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        ellipse = new Ellipse(x1,y1,x2,y2,lineColour, fillColour);
    }

    @Test
    void testEllipsetoVEC() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        ellipse = new Ellipse(x1,y1,x2,y2,lineColour, fillColour);

        String expected = "PEN #000000\nFILL #ffffff\nELLIPSE 0.55 0.33 0.44 0.22\n";

        assertEquals(expected, ellipse.toVec());

    }

    @Test
    void testEllipsetoString() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        ellipse = new Ellipse(x1,y1,x2,y2,lineColour, fillColour);

        String expected = "Ellipse";

        assertEquals(expected, ellipse.toString());
    }

    @Test
    void testPlotConstruction() {
        double x1 = 0.55;
        double y1 = 0.33;
        Color lineColour = Color.BLACK;

        plot = new Plot(x1,y1,lineColour);
    }

    @Test
    void testPlottoVEC() {
        double x1 = 0.55;
        double y1 = 0.33;
        Color lineColour = Color.BLACK;

        plot = new Plot(x1,y1,lineColour);

        String expected = "PEN #000000\nPLOT 0.55 0.33\n";

        assertEquals(expected, plot.toVec());
    }

    @Test
    void testPlottoString() {
        double x1 = 0.55;
        double y1 = 0.33;
        Color lineColour = Color.BLACK;

        plot = new Plot(x1,y1,lineColour);

        String expected = "Plot";

        assertEquals(expected, plot.toString());
    }

    @Test
    void testPolygonConstruction() {
        double[] x1 = {0.55,0.44,0.33};
        double[] y1 = {0.33,0.22,0.11};
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        polygon = new Polygon(x1,y1,lineColour,fillColour);
    }

    @Test
    void testPolygontoVEC(){
        double[] x1 = {0.55,0.44,0.33};
        double[] y1 = {0.33,0.22,0.11};
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        polygon = new Polygon(x1,y1,lineColour,fillColour);

        String expected = "PEN #000000\nFILL #ffffff\nPOLYGON 0.55 0.33 0.44 0.22 0.33 0.11\n";

        assertEquals(expected, polygon.toVec());
    }

    @Test
    void testPolygontoString() {
        double[] x1 = {0.55,0.44,0.33};
        double[] y1 = {0.33,0.22,0.11};
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        polygon = new Polygon(x1,y1,lineColour,fillColour);

        String expected = "Polygon";

        assertEquals(expected, polygon.toString());
    }

    @Test
    void testRectangleConstruction() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        rectangle = new Rectangle(x1,y1,x2,y2,lineColour,fillColour);
    }

    @Test
    void testRectangletoVEC() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        rectangle = new Rectangle(x1,y1,x2,y2,lineColour,fillColour);

        String expected = "PEN #000000\nFILL #ffffff\nRECTANGLE 0.55 0.33 0.44 0.22\n";

        assertEquals(expected, rectangle.toVec());
    }

    @Test
    void testRectangletoString() {
        double x1 = 0.55;
        double x2 = 0.44;
        double y1 = 0.33;
        double y2 = 0.22;
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        rectangle = new Rectangle(x1,y1,x2,y2,lineColour,fillColour);

        String expected = "Rectangle";

        assertEquals(expected, rectangle.toString());
    }

    @Test
    void testGraphicsContConstruction() {
        int canvasSize = 20;

        graphicsContainer = new GraphicsContainer(canvasSize);
    }

    @Test
    void testGraphicsContsetSize() {
        int canvasSize = 20;

        graphicsContainer = new GraphicsContainer(canvasSize);

        int expected = 20;

        assertEquals(expected, graphicsContainer.getSize());
    }

    @Test
    void testGraphicsConAddGetObj() {
        int canvasSize = 20;
        line = new Line(0.55,0.22,0.11,0.77,Color.BLACK);
        rectangle = new Rectangle(0.1,0.2,0.3,0.3,Color.BLACK,Color.WHITE);

        graphicsContainer = new GraphicsContainer(canvasSize);

        graphicsContainer.addObject(line);
        graphicsContainer.addObject(rectangle);

        List<Shapes> expected = new ArrayList<>();

        expected.add(line);
        expected.add(rectangle);

        assertEquals(expected, graphicsContainer.getObjects());
    }

    @Test
    void testGraphicsConRemObj() {
        int canvasSize = 20;
        line = new Line(0.55,0.22,0.11,0.77,Color.BLACK);
        rectangle = new Rectangle(0.1,0.2,0.3,0.3,Color.BLACK,Color.WHITE);

        graphicsContainer = new GraphicsContainer(canvasSize);

        graphicsContainer.addObject(line);
        graphicsContainer.addObject(rectangle);

        graphicsContainer.removeObject(0);

        List<Shapes> expected = new ArrayList<>();

        expected.add(rectangle);

        assertEquals(expected, graphicsContainer.getObjects());
    }

    @Test
    void testGUIConstruction() {
        gui = new GUI();
    }

    @Test
    void testToolsConstruction() {
        tools = tools.PLOT;
        tools = tools.LINE;
        tools = tools.ELLIPSE;
        tools = tools.POLYGON;
        tools = tools.RECTANGLE;

    }

    @Test
    void testCanvasDrawingConstruction() {
        gui = new GUI();
        canvasDrawing = new CanvasDrawing(gui);
    }

    @Test
    void testCanvasDrawSets() {
        gui = new GUI();
        canvasDrawing = new CanvasDrawing(gui);
        tools = tools.PLOT;
        Color lineColour = Color.BLACK;
        Color fillColour = Color.WHITE;

        canvasDrawing.setTool(tools);
        canvasDrawing.setLineColor(lineColour);
        canvasDrawing.setFillColor(fillColour);
    }

    @Test
    void testFileDrawingContruction() {
        fileDrawing = new FileDrawing();
    }

    @Test
    void testUndoGUIConstruction() {
        gui = new GUI();
        canvasDrawing = new CanvasDrawing(gui);
        undoGUI = new UndoGUI(canvasDrawing);
    }
}
