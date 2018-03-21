package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public interface UserAction {
    /**
     * Ввод пользователя(ответ), цифра которая показывает какое действие необходимо сделать.
     */
    int key();

    /**
     * Выполнение действия которое выбрал пользователь
     */
    void execute(Input input, Tracker tracker);

    /**
     * Информация о том действии.
     */
    String info();
}
