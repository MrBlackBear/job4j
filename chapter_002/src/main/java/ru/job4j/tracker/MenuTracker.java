package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Класс реализует изменение существующей заявки в хранилище
 */
class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }

    /**
     * Метод реализует изменение существующей заявки в хранилище
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Изменение заявки --------------");
        String id = input.ask("Введите id заявки :");
        String name = input.ask("Введите имя новой заявки :");
        String desc = input.ask("Введите описание новой заявки :");
        tracker.replace(id, new Item(name, desc));

    }
}

/**
 * MenuTracker.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    /**
     * Ввод
     */
    private Input input;
    /**
     * Трекер
     */
    private Tracker tracker;
    /**
     * Массив всех возможных действий
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор класса
     *
     * @param input   ввод
     * @param tracker трекер
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Наполнение действиями трекера
     */
    public void fillActions() {
        this.actions.add(0, this.new AddItem(0, "Add new Item"));
        this.actions.add(1, new MenuTracker.ShowAllItems(1, "Show all items"));
        this.actions.add(2, new EditItem(2, "Edit item"));
        this.actions.add(3, this.new DeleteItem(3, "Delete item"));
        this.actions.add(4, this.new FindItemById(4, "Find item by Id"));
        this.actions.add(5, this.new FindItemsByName(5, "Find items by name"));
    }

    /**
     * Выбор действия
     *
     * @param key выбор действия пользователя
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Показывание всех возможных действий по сути тоже самое менюгде просят выбрать что либо
     */
    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    /**
     * Класс реализует добавленяи новый заявки в хранилище.
     */
    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name:");
            String desc = input.ask("Enter description:");
            tracker.add(new Item(name, desc));
        }
    }

    /**
     * Класс в котором реализуется возможность показать все элементы которые на данный момент добавили в трекер
     */
    private static class ShowAllItems extends BaseAction {
        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        /**
         * Метод показывает все элементы которые на данный момент добавили в трекер
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Показывает все элементы --------------");
            ArrayList<Item> allItems = tracker.findAll();
            for (Item item : allItems) {
                System.out.println(String.format("------------ Заявка с getId : %s-----------", item.getId()));
            }
        }
    }

    /**
     * Класс в котором реализуется возможность удаления заявки
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует удаление заявки в хранилище.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            tracker.delete(id);
        }
    }

    /**
     * Класс в котором реализуется возможность нахождения заявки по id
     */
    private class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует нахождение заявки в хранилище по id.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Нахождение заявки --------------");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            System.out.println(String.format("------------ Id заявки : %s-----------", item.getId()));
            System.out.println(String.format("------------ Имя заявки : %s-----------", item.getName()));
            System.out.println(String.format("------------ Описание заявки : %s-----------", item.getDescription()));
        }
    }

    /**
     * Класс в котором реализуется возможность нахождения заявок по имени
     */
    private class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует нахождение заявок в хранилище по имени.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Нахождение заявок по имени --------------");
            String name = input.ask("Введите имя заявок :");
            ArrayList<Item> allItems = tracker.findByName(name);
            for (Item item : allItems) {
                System.out.println(String.format("------------ Заявка с getId : %s-----------", item.getId()));
            }
        }
    }
}
