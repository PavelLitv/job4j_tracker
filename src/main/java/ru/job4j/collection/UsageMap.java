package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> data = new HashMap<>();
        data.put("pasha@ya.ru", "Pavel Li");
        data.put("serg@ya.ru", "Sergey Petrov");
        data.put("unknow@ya.ru", "Pavel Li");
        for (String key : data.keySet()) {
            System.out.println(key + ": " + data.get(key));
        }
    }
}
