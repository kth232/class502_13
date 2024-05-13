package exam02;

public class ImplCalculator implements  Calculator{
    @Override
    public long factorial(long num) {
        long total = 1L;
        for(long i = 1; i <= num; i++){
            total *= i;
        }
        return total;
    } //for문으로 성능이 좋은 팩토리얼 함수 구현
}
