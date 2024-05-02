package exam01;

import java.util.function.Supplier;

public class Ex08 {
    public static void main(String[] args) {
        Supplier<Book> s1 = ()-> new Book(); //Supplier-매개변수 없이 반환값만 내보내는 인터페이스
        Supplier<Book> s2 = Book::new; //메서드 참조- Book 객체 생성

        Book b1 = s2.get();
        System.out.println(b1);
    }
}
