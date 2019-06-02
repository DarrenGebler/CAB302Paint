package VectorDesign;

import VectorDesign.VectorTools.Shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores all objects that are drawn to the canvas
 * Size is used for conversion between Vector 0-1 and canvas pixel coordinates.
 */
public class GraphicsContainer {
    private int canvasSize;
    private List<Shapes> objects;

    /**
     * Creates a new container for objects on the canvas
     * @param canvasSize specify the size of the canvas in pixels
     */
    public GraphicsContainer(int canvasSize) {
        this.canvasSize = canvasSize;
        objects = new ArrayList<Shapes>();
    }

    /**
     * Set the size of the canvas in pixels
     * @param size
     */
    public void setSize(int size) {
        this.canvasSize = size;
    }

    /**
     * Get the size of the canvas used for drawing objects
     * @return canvasSize
     */
    public int getSize() {
        return canvasSize;
    }

    /**
     * Add a graphics object to the container for drawing to the canvas
     * @param object Shapes object containing information to draw the object onto canvas
     */
    public void addObject(Shapes object) {
        objects.add(object);
    }

    /**
     * Remove a graphics object from the container for drawing to the canvas
     * @param index index to remove
     */
    public void removeObject(int index) {
        if (objects.size() > 0) {
            objects.remove(index);
        }
    }

    /**
     * Used for drawing objects in the list to the canvas
     * @return objects Return the list of objects in the container
     */
    public List<Shapes> getObjects() {
        return objects;
    }
}
