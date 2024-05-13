package exam01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("test1.txt", true)){ //파일 생성됨
            for(char ch = 'A'; ch <= 'Z'; ch++){ //문자도 기본 자료형
                fos.write(ch); //다시 실행하면 커서가 처음 위치로 이동->기존 것은 지워지고 다시 작성됨
            } // append 추가하면 커서 이동없음->덧붙여서 작성됨
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
