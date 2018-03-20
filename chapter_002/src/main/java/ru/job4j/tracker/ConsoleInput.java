package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    /**
     * Переменная для считывания ответа пользователя
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод для запроса данных у пользователя.
     *
     * @param question вопрос неоходимый задать пользователю
     * @return ответ который пришел от пользователя
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
