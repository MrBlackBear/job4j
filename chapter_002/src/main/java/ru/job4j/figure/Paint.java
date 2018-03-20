package ru.job4j.figure;

/**
 * Paint
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Method draw.
     *
     * @param shape some figure
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
