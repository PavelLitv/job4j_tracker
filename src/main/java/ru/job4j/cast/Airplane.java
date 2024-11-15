package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " полетел в небо");
    }

    @Override
    public void stop() {
        System.out.println(this.getClass().getSimpleName() + " приземлился в аэропорту");
    }
}
