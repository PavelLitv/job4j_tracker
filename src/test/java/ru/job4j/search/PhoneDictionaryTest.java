package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Popov", "534873", "Petrograd")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Popov", "534873", "Petrograd")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Popov");
    }

    @Test
    public void whenFindThenEmpty() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Popov", "534873", "Petrograd")
        );
        ArrayList<Person> persons = phones.find("Petrov");
        assertThat(persons).isEmpty();
    }
}