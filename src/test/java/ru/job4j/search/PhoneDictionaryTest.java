package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Popov", "534873", "Petrograd")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Popov", "534873", "Petrograd")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Popov");
    }

    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Popov", "534873", "Petrograd")
        );
        var persons = phones.find("Popov");
        assertThat(persons.get(0).getName()).isEqualTo("Ivan");
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Popov", "534873", "Petrograd")
        );
        var persons = phones.find("534");
        assertThat(persons.get(0).getSurname()).isEqualTo("Popov");
    }

    @Test
    public void whenFindThenEmpty() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Popov", "534873", "Petrograd")
        );
        var persons = phones.find("Petrov");
        assertThat(persons).isEmpty();
    }
}