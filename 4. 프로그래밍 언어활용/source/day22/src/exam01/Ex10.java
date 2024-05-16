package exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Ex10 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("data.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            HashMap<String, Object> data = new HashMap<>(); // 객체 저장, 자료가 다양할 때 사용
            Book book1 = new Book(1000, "book1", "author1");
            Book book2 = new Book(1001, "book2", "author2");

            List<Book> books = Arrays.asList( //순서 유지o, 책만 저장, 개수 미정->List
                new Book(1002, "book3", "author3"),
                new Book(1003, "book4", "author4")
            );
            data.put("book1", book1);
            data.put("book2", book2);
            data.put("books", books);
            data.put("str", "Hello");

            oos.writeObject(data);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
