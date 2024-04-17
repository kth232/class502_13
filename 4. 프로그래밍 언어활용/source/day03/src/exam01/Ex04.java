package exam01;

public class Ex04 {
    public static void main(String[] args) {
        Schedule2 s2=new Schedule2(2024, 4, 17);
        int year =s2.year();
        int month =s2.month();
        int day = s2.day();
        System.out.printf("%d-%d-%d %n", year, month, day);

        System.out.println(s2); // s2.toString();
    }
}
