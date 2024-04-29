package exam04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(); //조회 빠름
        books.add(new Book(1001, "book1", "author1"));
        books.add(new Book(1002, "book2", "author2"));
        books.add(new Book(1003, "book3", "author3"));
        books.add(new Book(1004, "book4", "author4"));
        books.add(new Book(1005, "book5", "author5"));

        Iterator<Book> iter = books.iterator();
        while(iter.hasNext()) {
            Book book = iter.next();
            System.out.println(book);
        }

        iter = books.iterator(); //한번 더 반복하려면 iter를 다시 만들어야 함
        while(iter.hasNext()){ //2번째 반복은 안됨->커서가 마지막에 위치하기 때문
            Book book = iter.next();
            System.out.println(book);
        }
    }
}
