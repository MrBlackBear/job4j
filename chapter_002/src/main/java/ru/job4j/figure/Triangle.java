package ru.job4j.figure;

/**
 * Triangle.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    /**
     * Method draw where draw triangle
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +  ");
        pic.append(" +++ ");
        pic.append("+++++");
        return pic.toString();
    }
}
