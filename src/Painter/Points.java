package Painter;

/**
 * Points function for assigning x, y Points
 * @author Darren Gebler, James Hassett
 */

public class Points {

    int x, y;

    /**
     * Assigns Points x, y
     * @param x
     * @param y
     */
    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x Point
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y Point
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets x Point
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y Point
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
}
