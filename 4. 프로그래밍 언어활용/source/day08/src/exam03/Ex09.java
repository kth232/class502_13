package exam03;

public class Ex09 {
    public static void main(String[] args) throws ClassNotFoundException { //클래스 파일을 찾지 못했을 때 예외 처리
        Class cls = Class.forName("exam03.Person"); // 해당 파일명으로 클래스 파일 찾아서 동적 로딩

    }
}
