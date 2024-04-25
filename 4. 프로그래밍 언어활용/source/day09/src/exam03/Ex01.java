package exam03;

public class Ex01 {
    public static void main(String[] args) {
        String fruit = String.join(",", "Apple", "Orange", "Mango"); //,로 구분
        System.out.println(fruit);

        String str = String.format("%d+%d=%d", 10, 20, 30);
        System.out.println(str);
    }
}
