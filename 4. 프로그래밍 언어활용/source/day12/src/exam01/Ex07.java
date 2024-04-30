package exam01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex07 {
    public static void main(String[] args) {
        //HashSet<Book> books = new HashSet<>(); //hashSet
        Set<Book> books = new TreeSet<>(Comparator.reverseOrder()); //treeSet: 집합+정렬, 다형성 Set/기본 정렬 기준의 반대
        books.add(new Book(1000, "book1", "author1"));
        books.add(new Book(1001, "book2", "author2"));
        books.add(new Book(1002, "book3", "author3"));
        books.add(new Book(1003, "book4", "author4"));
        books.add(new Book(1004, "book5", "author5"));
        books.add(new Book(1001, "book2", "author2")); //중복값
        // java.lang.Comparable 인터페이스 캐스팅->정렬 기준 정함
        // isbn, title, author 중 어느 것을 기준으로 정렬할지 모름->정렬 기준 지정 필요
        for (Book book: books){
            System.out.println(book);
        } //equals & hashCode 재정의로 중복 제거
    }
}
