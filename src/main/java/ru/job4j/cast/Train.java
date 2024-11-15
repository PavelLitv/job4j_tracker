package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " поехал по рельсам");
    }

    @Override
    public void stop() {
        System.out.println(this.getClass().getSimpleName() + " остановился на ж/д станции");
    }
}
