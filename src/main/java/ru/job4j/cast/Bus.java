package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " поехал по автомагистралям");
    }

    @Override
    public void stop() {
        System.out.println(this.getClass().getSimpleName() + " остановился на автобусной остановке");
    }
}
