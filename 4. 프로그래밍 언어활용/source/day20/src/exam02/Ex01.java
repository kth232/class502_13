package exam02;

public class Ex01 {
    public static void main(String[] args) {
        long stime = System.nanoTime(); //cal1 시작시간, 공통 추가 기능

        ImplCalculator cal1 = new ImplCalculator();
        long result1 = cal1.factorial(10L); //핵심 기능
        System.out.printf("cal1: %d%n", result1);

        long etime = System.nanoTime();
        System.out.printf("소요 시간: %d%n", etime - stime); //cal1 종료시간, 공통 추가 기능

        stime = System.nanoTime(); //cal2 시작시간, 공통적인 추가 기능

        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(10L); // 핵심 기능
        System.out.printf("cal2: %d%n", result2);

        etime = System.nanoTime(); //cal2 종료시간, 공통 추가 기능
        System.out.printf("소요 시간: %d%n", etime-stime);
    } //연산방식은 달라도 값은 동일함, 연산 시간은 차이남(컴퓨터가 안좋을수록 차이 큼)
}
