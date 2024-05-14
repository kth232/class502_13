package exam01;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("score.txt");
             DataInputStream dis = new DataInputStream(fis)) {
            int total=0, cnt = 0;

            try{
                while(true) {
                    int score = dis.readInt();
                    total +=score;
                    cnt++;
                }
            }catch (EOFException e){ // 예외발생->파일을 다 읽은 상태
                System.out.printf("total: %d, avg: %.2f", total, (double)total/cnt);
            }
            //파일을 다 읽어오면 내부에서 예외 발생->파일을 끝까지 읽은 것을 알 수 있다
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
