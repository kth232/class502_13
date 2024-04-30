package exam01;

import java.util.ArrayList;
import java.util.ListIterator;

public class Ex02 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1000, "book1", "author1"));
        books.add(new Book(1001, "book2", "author2"));
        books.add(new Book(1002, "book3", "author3"));
        books.add(new Book(1003, "book4", "author4"));
        books.add(new Book(1004, "book5", "author5"));

        ListIterator<Book> iter = books.listIterator();
        System.out.println("---순방향---");
        while(iter.hasNext()){
            int index = iter.nextIndex();
            Book book=iter.next();

            System.out.println(book);
            System.out.println("index: "+index);
        }
        System.out.println("---역방향---");
        while(iter.hasPrevious()){
            int index = iter.previousIndex();
            Book book = iter.previous();

            System.out.println(book);
            System.out.println("index: "+index);
        }
    }
}
