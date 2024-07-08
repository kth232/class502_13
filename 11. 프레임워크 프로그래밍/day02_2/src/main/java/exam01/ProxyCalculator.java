package exam01;

public class ProxyCalculator implements Calculator {

    //ImplCalculator, RecCalculator 대신 수행 주려면? 자료형?
    private Calculator calculator;

    public ProxyCalculator(Calculator calculator) { //외부에서 주입받음
        this.calculator = calculator; //대신 수행
    }

    @Override
    public long factorial(long num) {

        long stime = System.nanoTime(); //공통 기능

        try {
            //다른 계산기의 핵심 기능을 대신 수행(중점)=프록시
            long result = calculator.factorial(num); //다른 계산기의 factorial연산을 대신 수행함

            return result;
        } finally {
            long etime=System.nanoTime(); //공통 기능
            System.out.printf("소요 시간: %d%n", etime - stime);
        }
    }
}
