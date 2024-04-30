package exam01;

import java.util.ArrayList;

public class Ex03 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1000, "book1", "author1"));
        books.add(new Book(1001, "book2", "author2"));
        books.add(new Book(1002, "book3", "author3"));
        books.add(new Book(1003, "book4", "author4"));
        books.add(new Book(1004, "book5", "author5"));
/*
        for(Book book: books) { //향상된 for문->처음부터 끝까지 반복
            System.out.println(book);
        }
 */
        books.forEach(System.out::println); //forEach 함수
    }
}
