package ru.job4j.condition;

/**
 * Class point
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Point {
    /**
     * Contains X coordinate
     */
    private int x;
    /**
     * Contains Y coordinate
     */
    private int y;

    /**
     * Constructor of class point.
     *
     * @param x coordinate x.
     * @param y coordinate y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method distanceTo.
     *
     * @param that Point.
     * @return distance between our and someone point.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}

