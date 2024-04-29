package exam04;

public class Book { //private->변수 통제
    private int isbn; //book number
    private String title; //book name
    private String author;

    public Book(int isbn, String title, String author) { //생성자 함수, 초기화
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() { //내부 값 확인해보는 용도로 toString 재정의
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
