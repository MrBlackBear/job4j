package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех элементов
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа меню для изменения элемента
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления новой заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для нахождения новой заявки по идентификатору.
     */
    private static final String BY_ID = "4";

    /**
     * Константа меню для нахождения новых заявок по имени.
     */
    private static final String BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (BY_ID.equals(answer)) {
                this.findItemById();
            } else if (BY_NAME.equals(answer)) {
                this.itemsFindByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод метод показывает все элементы которые на данный момент добавили в трекер
     */
    private void showAllItems() {
        System.out.println("------------ Показывает все элементы --------------");
        Item[] allItems = this.tracker.findAll();
        for (Item item : allItems) {
            System.out.println("------------ Заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Метод реализует изменение существующей заявки в хранилище
     */
    private void editItem() {
        System.out.println("------------ Изменение заявки --------------");
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Item newItem = new Item(name, desc);
        String id = this.input.ask("Введите id заявки :");
        this.tracker.replace(id, newItem);
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
    }

    /**
     * Метод реализует нахождение заявки в хранилище по id.
     */
    private void findItemById() {
        System.out.println("------------ Нахождение заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        System.out.println("------------ Id заявки : " + item.getId() + "-----------");
        System.out.println("------------ Имя заявки : " + item.getName() + "-----------");
        System.out.println("------------ Описание заявки : " + item.getDescription() + "-----------");
    }

    /**
     * Метод реализует нахождение заявок в хранилище по имени.
     */
    private void itemsFindByName() {
        System.out.println("------------ Нахождение заявок по имени --------------");
        String name = this.input.ask("Введите имя заявок :");
        Item[] allItems = this.tracker.findByName(name);
        for (Item item : allItems) {
            System.out.println("------------ Заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Метод реализует меню программы.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}