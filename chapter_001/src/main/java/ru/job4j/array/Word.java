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
        for (int countInWord = 0; countInWord <= charsOfWord.length - value.length; countInWord++) {
            if (result == true) {
                break;
            }
            index = countInWord;
            for (int countInPrefix = 0; countInPrefix < value.length; countInPrefix++) {
                if (charsOfWord[index] != value[countInPrefix]) {
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
