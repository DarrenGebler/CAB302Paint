package VectorDesign;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import VectorDesign.VectorTools.*;
import VectorDesign.VectorTools.Polygon;
import VectorDesign.VectorTools.Rectangle;

/**
 * Handle importing from file and exporting to file
 */
public class FileDrawing {
    /**
     * Generate a GraphicContainer with objects loaded from a vector formatted file
     * @param path Path to vec formatted file
     * @return GraphicContainer containing objects read from file
     * @throws FileNotFoundException
     */
    public static GraphicsContainer fileImport(String path) throws FileNotFoundException {
        // Container to write parsed file contents to
        GraphicsContainer fileObjects = new GraphicsContainer(0);

        // Default drawing properties
        Color lineColor = Color.BLACK;
        Color fillColor = null;

        File vecFile = new File(path);
        Scanner openFile = new Scanner(vecFile);

        while (openFile.hasNextLine()) {
            String[] instruction = openFile.nextLine().split(" ");

            switch (instruction[0]) {
                case "PEN":
                    lineColor = Color.decode(instruction[1]);
                    break;
                case "FILL":
                    if (instruction[1].equals("OFF")) {
                        fillColor = null;
                    } else {
                        fillColor = Color.decode(instruction[1]);
                    }
                    break;
                case "PLOT":
                    Shapes addPlot = new Plot(Double.parseDouble(instruction[1]), Double.parseDouble(instruction[2]), lineColor);
                    fileObjects.addObject(addPlot);
                    break;
                case "LINE":
                    Shapes addLine = new Line(Double.parseDouble(instruction[1]), Double.parseDouble(instruction[2]),
                                                Double.parseDouble(instruction[3]), Double.parseDouble(instruction[4]), lineColor);
                    fileObjects.addObject(addLine);
                    break;
                case "RECTANGLE":
                    Shapes addRectangle = new Rectangle(Double.parseDouble(instruction[1]), Double.parseDouble(instruction[2]),
                                                            Double.parseDouble(instruction[3]), Double.parseDouble(instruction[4]), lineColor, fillColor);
                    fileObjects.addObject(addRectangle);
                    break;
                case "ELLIPSE":
                    Shapes addEllipse = new Ellipse(Double.parseDouble(instruction[1]), Double.parseDouble(instruction[2]),
                                                        Double.parseDouble(instruction[3]), Double.parseDouble(instruction[4]), lineColor, fillColor);
                    fileObjects.addObject(addEllipse);
                    break;
                case "POLYGON":
                    double[] xValues = new double[instruction.length / 2];
                    double[] yValues = new double[instruction.length / 2];

                    int vertex = 0;
                    for (int coord=1; coord<instruction.length-1; coord+=2) {
                        xValues[vertex] = Double.parseDouble(instruction[coord]);
                        yValues[vertex] = Double.parseDouble(instruction[coord + 1]);

                        vertex++;
                    }

                    Shapes addPolygon = new Polygon(xValues, yValues, lineColor, fillColor);
                    fileObjects.addObject(addPolygon);
                    break;
                default:
                    break;
            }
        }

        openFile.close();
        return fileObjects;
    }

    /**
     * Export GraphicsContainer object to a file using toVec()
     * @param path file path to save to
     * @param canvasObjects list of objects from the canvas
     * @throws IOException
     */
    public static void fileExport(String path, GraphicsContainer canvasObjects) throws IOException {
        FileWriter openFile = new FileWriter(path);

        // Write each object instruction to file
        for (Shapes object : canvasObjects.getObjects()) {
            openFile.write(object.toVec());
        }
        openFile.close();
    }
}
