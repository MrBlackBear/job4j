package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int quantity = 0;
        Task element = null;
        for (Task t : this.tasks) {
            if (t.getPriority() <= task.getPriority()) {
                quantity++;
            }  else {
                element = t;
                break;
            }
        }
        if (quantity == tasks.size()) {
            this.tasks.add(quantity, task);
        }else {
            this.tasks.add(tasks.indexOf(element), task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
