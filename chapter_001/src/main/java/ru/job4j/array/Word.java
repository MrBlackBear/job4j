package ru.job4j.array;

/**
 * Word
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Word {
    /**
     * Проверяет. что в слове есть префикс.
     *
     * @param prefix префикс.
     * @param word   само слово
     * @return true если есть префикс, или false если нету
     */
    public boolean contains(String word, String prefix) {
        char[] charsOfWord = word.toCharArray();
        boolean result = false;
        char[] value = prefix.toCharArray();
        int index;
        for (int i = 0; i <= charsOfWord.length - value.length; i++) {
            if (result == true) {
                break;
            }
            index = i;
            for (int j = 0; j < value.length; j++) {
                if (charsOfWord[index] != value[j]) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
                index++;
            }
        }
        return result;
    }
}
