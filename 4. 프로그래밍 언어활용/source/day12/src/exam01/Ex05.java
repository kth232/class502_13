package exam01;

import java.util.HashSet;

public class Ex05 {
    public static void main(String[] args) {
        HashSet<Book> books = new HashSet<>();
        books.add(new Book(1000, "book1", "author1"));
        books.add(new Book(1001, "book2", "author2"));
        books.add(new Book(1002, "book3", "author3"));
        books.add(new Book(1003, "book4", "author4"));
        books.add(new Book(1004, "book5", "author5"));
        books.add(new Book(1001, "book2", "author2")); //중복값
        for (Book book: books){
            System.out.println(book);
        } //equals & hashCode 재정의로 중복 제거
    }
}
