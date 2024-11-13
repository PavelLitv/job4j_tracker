package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item result = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        int size = 0;
        for (int index = 0; index < result.length; index++) {
            if (items[index] != null) {
                result[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item[] findByName(String name) {
        Item[] result = new Item[size];
        int size = 0;
        for (int index = 0; index < result.length; index++) {
            if (items[index] != null && name.equals(items[index].getName())) {
                result[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }
}
