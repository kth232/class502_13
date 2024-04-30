package exam01;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1000, "book1", "author1"));
        books.add(new Book(1001, "book2", "author2"));
        books.add(new Book(1002, "book3", "author3"));
        books.add(new Book(1003, "book4", "author4"));
        books.add(new Book(1004, "book5", "author5"));

        Iterator<Book> iter = books.iterator();
        while(iter.hasNext()){ //커서 이동 방식으로 반복, 마지막 가리키면 정로
            Book book = iter.next();
            System.out.println(book);
        }
        iter = books.iterator(); // 새로 시작해야 커서 이동
        while(iter.hasNext()){ //커서 이동 방식으로 반복
            Book book = iter.next();
            System.out.println(book);
        }

    }
}
