package ru.job4j.array;

/**
 * Обертка над строкой.
 * ArrayChar
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {
    /**
     * Contains array of char
     */
    private char[] data;

    /**
     * Constructor of class ArrayChar.
     *
     * @param line line which converted in char array in which we look for prefix
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (this.data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
