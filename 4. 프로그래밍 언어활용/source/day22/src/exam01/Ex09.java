package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex09 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("book.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            /**
             * Book book = new Book(.., .., ..);
             * 복구 시에 필요한 데이터가 저장됨->다시 객체 생성, 값 대입
             * 작성한 순서 그대로 불러와야 함->순서 바뀌면 오류 발생
             */
            Book book1 = (Book)ois.readObject();
            System.out.println(book1);

            Book book2 = (Book)ois.readObject();
            System.out.println(book2);

            String str = (String)ois.readObject();
            System.out.println(str);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
