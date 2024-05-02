package exam02;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Ex09 {
    public static void main(String[] args) {
        int[] scores = {60, 78, 90, 87, 96};
        IntSummaryStatistics stat = Arrays.stream(scores).summaryStatistics(); //IntStream으로 변경
        double avg = stat.getAverage();
        long count = stat.getCount();
        int max = stat.getMax();
        int min = stat.getMin();
        long sum = stat.getSum();

        System.out.printf("평균: %.2f, 총 개수: %d, 최대: %d, 최소: %d, 합계: %d%n",avg, count, max, min, sum);
    }//정수 특화된 통계 기능, 기본형이기 때문에 연산 수행도 좋다
}
