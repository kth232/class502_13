package exam01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in; //바이트 단위 시스템
        InputStreamReader isr = new InputStreamReader(in); // InputStream -> Reader 보조스트림
        char ch = (char)isr.read(); //알파벳은 잘 출력되나 한글은 문자표가 달라 깨짐->문자표 맞춤
        System.out.println(ch);
    }
}
