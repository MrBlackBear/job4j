package ru.job4j.tracker;

import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

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
        this.items[this.position++] = item;
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
            if (item != null && item.getId().equals(id)) {
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
        Item result = this.findById(id);
        result.setId(item.getId());
        result.setCreate(item.getCreate());
        result.setDescription(item.getDescription());
        result.setName(item.getName());
    }

    /**
     * Метод возвращает элементы что уже добавили и олько их без пустых ячеек
     *
     * @return возвращает массив только эелментов которые уже добавили.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод удаляет элемент найденный по id и сдвигает массив на 1 влево
     *
     * @param id уникальный идентификатор
     */
    public void delete(String id) {
        int pos = 0;
        for (int index = 0; index != position; index++) {
            if (items[index].getId().equals(id)) {
                pos = index;
                break;
            }
        }
        position--;
        System.arraycopy(items, pos + 1, items, pos, 100 - 1 - pos);
    }

    /**
     * Метод находит по имени нужные элементы.
     *
     * @param key имя по которому мы ищем
     * @return массив с эелементами которые нашлись
     */
    public Item[] findByName(String key) {
        Item[] actual = new Item[100];
        int pos = 0;
        for (int i = 0; i != position; i++) {
            if (items[i].getName().equals(key)) {
                actual[pos++] = items[i];
            }
        }
        Item[] result = new Item[pos];
        System.arraycopy(actual, 0, result, 0, pos);
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