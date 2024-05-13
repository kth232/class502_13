package exam02;

public class RecCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        if (num < 1L){
            return 1L;
        }
        return num * factorial(num -1);
    } //재귀함수로 성능이 안좋은 팩토리얼 함수 구현->메모리 소비 큼
}
