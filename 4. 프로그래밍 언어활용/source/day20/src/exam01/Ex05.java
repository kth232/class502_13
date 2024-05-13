package exam01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        long stime = System.currentTimeMillis(); //1/1000초 단위로 작업 시작 시간 확인
        try (FileInputStream fis = new FileInputStream("specs.zip");
             FileOutputStream fos = new FileOutputStream("specs_copied.zip")){
            while(fis.available()>0){
                fos.write(fis.read()); //1바이트씩 읽고 쓰기->4초 정도 소요됨
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long etime = System.currentTimeMillis(); //작업 종료 시간 확인
        System.out.printf("소요 시간: %d%n", etime-stime);
    }
}
