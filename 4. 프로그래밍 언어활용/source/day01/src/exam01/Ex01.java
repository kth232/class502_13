package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(); //s1=지역변수, new 연산자로 객체 생성
        s1.id = 20240101; //메모리를 할당받고 실체가 된 객체=인스턴스
        s1.name = "kim";
        s1.subject = "JAVA";

        s1.study();
    }
}
