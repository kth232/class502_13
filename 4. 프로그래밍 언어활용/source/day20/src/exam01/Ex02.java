package exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test2.txt");
            /*
            while(fis.available()> 0){
                System.out.print((char)fis.read()); //문자 형태로 하나씩 읽어옴
            } //한글은 문자표가 서로 맞지 않아 깨져서 출력됨
            */
             // 읽고 준비하는 것 반복->비효율적
            InputStreamReader isr = new InputStreamReader(fis)) {
                int ch = 0;
                while((ch = isr.read()) != -1) {
                    System.out.print((char)ch);
                }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
