package ru.job4j;

public class Department implements Comparable<Department> {
    private String name;
    /**
     * Priority
     */
    private int ier;

    public Department(String name, int length) {
        this.name = name;
        this.ier = length;
    }

    public String getName() {
        return name;
    }

    public int getIer() {
        return ier;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Department o) {
        return this.getName().compareTo(o.getName());
    }
}
