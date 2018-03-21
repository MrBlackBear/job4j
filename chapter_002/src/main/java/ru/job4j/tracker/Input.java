package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    /**
     * Метод для запроса данных у пользователя.
     *
     * @param question вопрос который необходимо задать пользователю
     */
    String ask(String question);

    int ask(String question, int[] range);
}
