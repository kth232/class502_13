package exam03;

import exam02.Calculator;

public class RecCalculator implements Calculator {
    @Override
    public long factorial(long num) { //재귀함수
        if (num < 1L) {
            return 1L;
        }
        return num * factorial(num - 1L);
    }
}
