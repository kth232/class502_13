package exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException; //extends IOException ->다형성
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("b.txt"); //파일은 애플리케이션 종료 시 할당받은 메모리 해제
            System.out.println("file 작업..");
            /*
            fis.close(); //IOException 예외 처리 필요/작업 완료했다면->(예외가 없을 때만)자원 해제
            System.out.println("자원 해제 complete");
             */
        } catch (IOException e) { //처리가 다를 땐 나눠서 해야하지만 동일한 처리를 할 때는 굳이 나누지 않고 다형성으로 한번에 처리(처리 유연성) ->FileNotFoundException e
            e.printStackTrace();
            /*
            if (fis != null) { //예외가 있을 때도 자원 해제
                try {
                    fis.close();
                } catch (IOException e2) {

                }
            }
            */
        } finally { //무조건 수행해야하는 작업들
            System.out.println("무조건 실행");
            if (fis != null) { // 예외 발생 유무에 상관없이 자원 해제는 항상 필요한 작업이기 때문에 finally 부분에 모음
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
