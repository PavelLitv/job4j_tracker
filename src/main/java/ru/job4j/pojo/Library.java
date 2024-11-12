package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("Robinson Crusoe", 130);
        Book book3 = new Book("Robin Good", 210);
        Book book4 = new Book("Head First", 250);
        Book[] books = {book1, book2, book3, book4};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " - " + books[i].getPages());
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " - " + books[i].getPages());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals("Clean code")) {
                System.out.println(books[i].getTitle() + " - " + books[i].getPages());
            }
        }
    }
}
