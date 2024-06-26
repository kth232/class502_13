package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("data.obj");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            HashMap<String, Object> data = (HashMap<String, Object>) ois.readObject();
            //컬렉션 형태로 저장
            List<Book> books = (List <Book>)data.get("books");
            String str = (String)data.get("str");
            Book book1 = (Book)data.get("book1");
            Book book2 = (Book)data.get("book2");

            books.forEach(System.out::println);
            System.out.println(str);
            System.out.println(book1);
            System.out.println(book2);
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
