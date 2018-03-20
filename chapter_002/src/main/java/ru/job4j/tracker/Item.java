package ru.job4j.tracker;

/**
 * Item.
 *
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    /**
     * Уникальный идентификатор
     */
    private String id;

    /**
     * Имя
     */
    private String name;

    /**
     * Описание
     */
    private String description;

    /**
     * Создание
     */
    private long create;

    /**
     * Стандартный конструктор
     */
    public Item() {
    }

    /**
     * Конструктор
     *
     * @param name        имя
     * @param description описание
     * @param create      создание
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Конструктор
     *
     * @param name        имя
     * @param description описание
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


    /**
     * Возвращает id
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Возвращает name
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Возвращает create
     */
    public long getCreate() {
        return create;
    }

    /**
     * Устанавливает  create
     */
    public void setCreate(long create) {
        this.create = create;
    }
}
