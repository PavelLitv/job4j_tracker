package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setGroup("Economy");
        student.setDateAdmission(new Date());
        System.out.printf(
                "Student %s, study %s, entered the university %tD",
                student.getFullName(), student.getGroup(), student.getDateAdmission()
        );
    }
}
