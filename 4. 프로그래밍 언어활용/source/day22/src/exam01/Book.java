package exam01;

import java.io.Serializable;

public class Book implements Serializable { //문자 직렬화
    private int isbn; //도서번호
    private String title; //도서명
    private transient String author; //저자, transient: 직렬화 배제(민감한 정보일 시)->null로 출력

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
