package exam01;

import java.io.IOException;
import java.io.PrintStream;

public class Ex02 {
    public static void main(String[] args) throws IOException { //예외전가
        PrintStream out = new PrintStream("20240516.log"); //로그파일로 에러 확인
        System.setErr(out);

        String str = null;
        str.toUpperCase();
    }
}
