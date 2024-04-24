package exam01;

import java.util.Objects;

public class Book {
    private int isbn;
    private String title;
    private String author;

    public Book(int isbn, String title, String author){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
    }

    @Override //equals 메서드 재정의, 사용자의 가치관 유입됨
    public boolean equals(Object obj) { //3가지 값이 같으면 같은 객체임
        if (obj instanceof Book) {
            Book book = (Book)obj; // Object obj = b2 다형성, obj에 들어오는 객체가 book의 객체만 있도록 제한
            if (isbn == book.isbn && title.equals(book.title)&&author.equals(book.author)){ //문자열은 주소가 다를 수 있기 때문에 동등성 비교해서 확인
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() { //hashCode 재정의
        return Objects.hash(isbn, title, author);
    }

    @Override
    public String toString() {
        return String.format("isbn=%d, title=%s, author=%s%n", isbn, title, author);
    }
}
