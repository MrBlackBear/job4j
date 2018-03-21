package ru.job4j.tracker;

/**
 * Класс реализует изменение существующей заявки в хранилище
 */
class EditItem implements UserAction {
    @Override
    public int key() {
        return 2;
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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
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
    private UserAction[] actions = new UserAction[6];

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
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindItemById();
        this.actions[5] = this.new FindItemsByName();
    }

    /**
     * Выбор действия
     *
     * @param key выбор действия пользователя
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
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
    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        /**
         * Метод реализует добавленяи новый заявки в хранилище.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println(String.format("------------ Новая заявка с getId : %s-----------", item.getId()));

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    /**
     * Класс в котором реализуется возможность показать все элементы которые на данный момент добавили в трекер
     */
    private static class ShowAllItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        /**
         * Метод показывает все элементы которые на данный момент добавили в трекер
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Показывает все элементы --------------");
            Item[] allItems = tracker.findAll();
            for (Item item : allItems) {
                System.out.println(String.format("------------ Заявка с getId : %s-----------", item.getId()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Класс в котором реализуется возможность удаления заявки
     */
    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * Класс в котором реализуется возможность нахождения заявки по id
     */
    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }

    /**
     * Класс в котором реализуется возможность нахождения заявок по имени
     */
    private class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        /**
         * Метод реализует нахождение заявок в хранилище по имени.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Нахождение заявок по имени --------------");
            String name = input.ask("Введите имя заявок :");
            Item[] allItems = tracker.findByName(name);
            for (Item item : allItems) {
                System.out.println(String.format("------------ Заявка с getId : %s-----------", item.getId()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }
}
