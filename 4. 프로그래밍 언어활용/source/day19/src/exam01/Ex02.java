package exam01;

public class Ex02 {
    public static void main(String[] args) {
        double num = 123.12345678;
        System.out.printf("%010.2f%n", num); //자릿수만큼 표기하고 남는 자리는 0으로 채움
        System.out.printf("%.2f%n", num); //소수점 자릿수만큼 표기
    }
}
