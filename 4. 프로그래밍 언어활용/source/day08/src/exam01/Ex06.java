package exam01;

import java.util.HashSet;

public class Ex06 {
    public static void main(String[] args) {
        HashSet<Book> books = new HashSet<>();
        books.add(new Book(1001, "book1", "author1"));
        books.add(new Book(1001, "book1", "author1"));
        books.add(new Book(1001, "book2", "author2"));
        books.add(new Book(1001, "book3", "author3"));
        books.add(new Book(1001, "book4", "author4"));
        books.add(new Book(1001, "book5", "author5"));
        for (Book book : books) { //향상된 for문: for-each 순서대로 반복
            System.out.println(book);
        }
    }
}
