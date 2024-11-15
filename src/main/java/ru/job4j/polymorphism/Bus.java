package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Bus move");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Capacity of the bus is " + count);
    }

    @Override
    public void refuel(int fuel) {
        System.out.println("Bus refuel " + fuel);
    }
}
