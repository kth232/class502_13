package exam01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test1.txt");
            DataInputStream dis = new DataInputStream(fis)){ //보조 스트림, 기반 스트림이 반드시 필요함
            byte num = dis.readByte();
            char ch = dis.readChar();
            String str = dis.readUTF();
            //작성한 순서대로 불러와야 함,순서 바뀌면 오류 발생
            //자료형 바껴도 오류->작성한 값의 크기만큼만 데이터를 기록하기 때문

            System.out.printf("num:%d, ch=%c, str=%s%n", num, ch, str);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
