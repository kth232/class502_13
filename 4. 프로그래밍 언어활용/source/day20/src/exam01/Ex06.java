package exam01;

import java.io.*;

public class Ex06 {
    public static void main(String[] args) {
        long stime = System.currentTimeMillis(); //1/1000초 단위로 작업 시작 시간 확인
        try (FileInputStream fis = new FileInputStream("specs.zip"); //바이트 단위 스트림
             BufferedInputStream bis = new BufferedInputStream(fis); //추가 기능
             FileOutputStream fos = new FileOutputStream("specs_copied2.zip");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {//버퍼를 사용해서 읽고 쓰기-> 1초 정도로 소요 시간 감축
            while(bis.available() > 0) {//8Kb 버퍼가 다 차면->비우기->출력
                bos.write(bis.read()); //마지막 구간 8Kb 버퍼는 다 차지 않을 수 있음->flush()로 마지막 버퍼 비워주기->close
            } //close 호출 전 flush 자동 호출
        } catch (IOException e){
            e.printStackTrace();
        }
        long etime = System.currentTimeMillis(); //작업 종료 시간 확인
        System.out.printf("소요 시간: %d%n", etime-stime);
    }
}
