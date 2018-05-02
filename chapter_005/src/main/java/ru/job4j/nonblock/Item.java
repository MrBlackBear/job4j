package ru.job4j.nonblock;

import java.util.Objects;

public class Item {
    /**
     * ID.
     */
    private final int id;

    /**
     * Version.
     */

    private int version = 0;

    /**
     * Data.
     */
    private final String data;

    /**
     * Constructor.
     *
     * @param id   int.
     * @param data String.
     */
    public Item(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    int getVersion() {
        return version;
    }

    public void incrementVersion() {
        version++;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && version == item.version && Objects.equals(data, item.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, data);
    }
}
