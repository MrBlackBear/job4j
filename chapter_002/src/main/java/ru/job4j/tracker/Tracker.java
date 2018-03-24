package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Случайно сгенерированное число
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод реализаущий нахождение элемента по id
     *
     * @param id уникальный идентификатор
     * @return возвращает элемент по найденному идентификатору
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод реализаущий изменение одного эелемента другим
     *
     * @param id   уникальный идентификатор
     * @param item элемент на который мы меняем
     */
    public void replace(String id, Item item) {
        Item result = null;
        for (Item t : this.items) {
            if (t.getId().equals(id)) {
                result = t;
                break;
            }
        }
        result.setName(item.getName());
        result.setCreate(item.getCreate());
        result.setDescription(item.getDescription());
    }

    /**
     * Метод возвращает элементы что уже добавили и олько их без пустых ячеек
     *
     * @return возвращает массив только эелментов которые уже добавили.
     */
    public ArrayList<Item> findAll() {
        return this.items;
    }

    /**
     * Метод удаляет элемент найденный по id и сдвигает массив на 1 влево
     *
     * @param id уникальный идентификатор
     */
    public void delete(String id) {
        Item itemFound = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                itemFound = item;
                break;
            }
        }
        this.items.remove(itemFound);
    }

    /**
     * Метод находит по имени нужные элементы.
     *
     * @param key имя по которому мы ищем
     * @return массив с эелементами которые нашлись
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}