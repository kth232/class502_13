package exam02;

import java.text.ChoiceFormat;

public class Ex05 {
    public static void main(String[] args) {
        /*
        double[] limits = {60, 70, 80, 90};
        String[] grades = {"D", "C", "B", "A"};
        ChoiceFormat cf = new ChoiceFormat(limits, grades);
        */
        String pattern = "60#D|70#C|80<B|90#A"; //패턴과 등급을 동시에 설정
        ChoiceFormat cf = new ChoiceFormat(pattern);

        int [] scores = {100, 70, 55, 80, 95, 87};
        for(int score:scores) {
            String grade = cf.format(score);
            System.out.printf("score: %d, grade: %s%n", score, grade);
        }
    }
}
