package ru.job4j.cast;

public class VehiclePark {
    public static void main(String[] args) {
        Vehicle boing = new Airplane();
        Vehicle airbus = new Airplane();
        Vehicle swift = new Train();
        Vehicle swallow = new Train();
        Vehicle eurolines = new Bus();
        Vehicle regabus = new Bus();
        Vehicle[] vehicles = {boing, airbus, swift, swallow, eurolines, regabus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.stop();
            System.out.println();
        }
    }
}
