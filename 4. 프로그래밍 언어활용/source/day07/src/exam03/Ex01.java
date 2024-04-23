package exam03;

public class Ex01 {
    public static void main(String[] args) throws Exception{
        Resources res = new Resources();
        Resources2 res2 = new Resources2();
        try(res; res2) { //안쪽(오른쪽->왼쪽)부터 처리함

        /*
        try(Resources res = new Resources();
            Resources2 res2 = new Resources2()) { //close();

         */
            // res가 AutoCloseable 인터페이스 구현 객체인지 체크-> close() 메서드 자동호출
            // 자원 해제가 필요한 모든 구현체가 AutoCloseable의 구현체,다형성 사용
            // AutoClosable auto = res; 자동 형변환
            // auto.close(); 자원해제
            // try-with-resources문
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
