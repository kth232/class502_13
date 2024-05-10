package exam02;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test1.txt")){
            byte[] buffer = new byte[5]; //버퍼 임시 메모리에 저장해서 한번에 읽어오기->효율성 증가
            while(fis.available()>0){
                int ch = fis.read(buffer); //ch=읽어온 바이트 수
                //System.out.println(ch);
                for (int i = 0; i < ch; i++){ //비우고 새로 담음=작업량 증가->효율성을 위해 기존 버퍼에 덮어씌우는 방식으로 담아온다
                    System.out.print((char)buffer[i]);
                }
                System.out.println();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
