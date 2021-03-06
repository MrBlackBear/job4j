package ru.job4j.loop;

/**
 * Board.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * Method paint.
     *
     * @param width  width of board.
     * @param height height of board.
     * @return figure board in pseudo-graphic.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if ((row + col) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
