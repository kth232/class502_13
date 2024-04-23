package exam06;

public class Ex03 {
    public static void main(String[] args) {
        Book b1 = new Book(1001, "book1", "author1");
        Book b2 = new Book(1001, "book1", "author1");
        System.out.printf("b1==b2: %s%n", b1 == b2); //내용이 같아도 다른 객체->주소 다름
        System.out.printf("b1.equals(b2): %s%n", b1.equals(b2)); //동등성 비교
    }
}
