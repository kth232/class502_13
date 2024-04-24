package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Book b1 = new Book(1001, "book1", "author1");
        System.out.println(b1); // b1.toString() / Object toString()
        Class cls = Book.class;
        Class cls2 = b1.getClass();
    }
}
