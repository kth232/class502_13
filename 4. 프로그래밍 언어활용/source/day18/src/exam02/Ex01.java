package exam02;

import java.text.DecimalFormat;

public class Ex01 {
    public static void main(String[] args) {
        double num1 = 1000000000.123;

        DecimalFormat df = new DecimalFormat("0,000.000000"); //0 패턴
        String num1Str = df.format(num1);
        System.out.println(num1Str);

        DecimalFormat df2 = new DecimalFormat("#,###.######"); //# 패턴
        String num1Str2 = df2.format(num1);
        System.out.println(num1Str2);

    }
}
