package exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex08 {
    public static void main(String[] args) throws IOException {
        try(FileOutputStream fos = new FileOutputStream("book.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            Book book1 = new Book(1000, "book1", "author1");
            Book book2 = new Book(1001, "book2", "author2");

            oos.writeObject(book1);
            oos.writeObject(book2);
            oos.writeObject("Hello"); //스트림 객체

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
