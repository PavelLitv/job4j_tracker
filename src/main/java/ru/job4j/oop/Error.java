package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.show();
        System.out.println();
        Error compile = new Error(true, 1, "Error compile");
        compile.show();
        System.out.println();
        Error memory = new Error(true, 2, "Error memory");
        memory.show();
        System.out.println();
        Error cpu = new Error(false, 3, "Error cpu");
        cpu.show();
    }
}
