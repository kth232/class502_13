package exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex02 {
    public static void main(String[] args) {
        //throw new FileNotFoundException(...)
        try {
            FileInputStream fis = new FileInputStream("b.txt"); //파일 있는지 체크
            System.out.println("file hangle.."); //오류 발생 시 실행 안됨
        } catch(FileNotFoundException e) { //오류 발생 시 catch 부분으로 넘어옴
            System.out.println("error");
            /*
            String message = e.getMessage(); //메세지를 통해 오류 원인 정보 출력
            System.out.println(message);
            */
            e.printStackTrace(); //복합적 오류를 찾을 때 사용, 오류 발생 위치부터 파생된 위치까지 알려줌
        }
        System.out.println("very important code..");
    }
}
