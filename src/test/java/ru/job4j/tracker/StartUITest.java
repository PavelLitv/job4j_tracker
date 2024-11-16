package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenAddItemThenItemNamePolly() {
        String[] answers = {"Polly"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Polly");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenCreateItemThenItemId1() {
        String[] answers = {"Polly"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        assertThat(created.getId()).isEqualTo((1));
    }
}