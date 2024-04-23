package exam02;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("a.txt")){
            // AutoCloseable auto= fis; <-내부적으로 동작함
            //예외 발생 없고 자원 할당만 할 때
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
