package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        String message = String.format("My nick %s, I was eating a %s", this.name, this.food);
        System.out.println(message);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public String sound() {
        return "may-may";
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("cutlet");
        gav.giveNick("Gav");
        gav.show();
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}
