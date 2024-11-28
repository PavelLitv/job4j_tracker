package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> findByName = (person) -> person.getName().contains(key);
        Predicate<Person> findByAddress = (person) -> person.getAddress().contains(key);
        Predicate<Person> findBySurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> findByPhone = (person) -> person.getPhone().contains(key);
        var combine = findByName.or(findByAddress).or(findBySurname).or(findByPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
