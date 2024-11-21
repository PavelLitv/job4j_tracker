package ru.job4j.tracker.comparator;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    void whenCompareAscByName() {
        List<Item> expected = List.of(
                new Item(2, "Bobi"),
                new Item(1, "Rubi"),
                new Item(3, "Sara")
        );
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Rubi"));
        items.add(new Item(2, "Bobi"));
        items.add(new Item(3, "Sara"));
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}