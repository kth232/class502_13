package exam02;

public class DecorateCalculator implements Calculator{
    private Calculator calculator;
    public DecorateCalculator(Calculator calculator){
        this.calculator = calculator;
    }

    public long factorial(long num) {
        long stime = System.nanoTime(); //cal1 시작시간, 공통 추가 기능
        try {
            long result = calculator.factorial(num); //핵심 기능을 대신 수행
            return result;
        } finally { //finally를 사용해서 return 이후에도 코드 사용
            long etime = System.nanoTime(); //공통 추가 기능
            System.out.printf("소요 시간: %d%n", etime - stime);
        } //여러 cal도 같이 수행할 수 있어야 범용성 증가->외부에서 제공받는 형태로, 다형성 사용
    }
}
