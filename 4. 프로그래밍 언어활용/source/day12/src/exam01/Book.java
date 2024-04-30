package exam01;

import java.util.Objects;

public class Book implements Comparable<Book> { //private=통제, Comparable 추상메서드
    private int isbn; //도서번호
    private String title; //도서명
    private String author; //저자

    public Book(int isbn, String title, String author) { //생성자
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

    //중복 제거 기준
    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author);
    }// 같은 값=값은 해시코드

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book){ //출처 체크
            Book book = (Book)obj; //명시적 형변환
            if(isbn == book.isbn && title.equals(book.title)&&author.equals(book.author)){
                return true;
            } //도서번호, 제목, 저자가 모두 같으면 같은 책임
        }
        return false;
    }

    @Override
    public int compareTo(Book o) {
        return isbn - o.isbn; //오름차순: 현재 객체 - 비교 객체
        //return o.isbn - isbn; //내림차순: 비교 객체 - 현재 객체
    } //Comparalbe 메서드 재정의->정렬 기준
}
