package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Book b1 = new Book(1001, "book1", "author1");
        Book b2 = new Book(1001, "book1", "author1"); //값은 같지만 다른 객체
        System.out.printf("b1==b2: %s%n", b1==b2); //false ->주소 다름
        System.out.printf("b1.equals(b2): %s%n", b1.equals(b2)); //false, Object-equals(..)-> == /true, equals() 재정의
        System.out.printf("b1 adress: %s%n",  System.identityHashCode(b1));
        System.out.printf("b2 adress: %s%n",  System.identityHashCode(b2)); // 각각 다른 주소에 저장
    }
}
