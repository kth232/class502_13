package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(); //s1: 지역변수, 참조변수 ->스택 메모리에 저장
        s1.id = 202411; //공간 할당 받아 변수(객체)가 됨
        s1.name = "kim"; //id, name, subject: 인스턴스 변수, 멤버 변수 ->힙 메모리에 저장
        s1.subject = "JAVA";
        System.out.println(s1.id);
        s1.study(); //인스턴스 메서드

        Student s2 = new Student(); //Student: 참조 자료형
        s2.id = 202412;
        s2.name = "lee";
        s2.subject = "Java Script";
        s2.study();

        System.out.println("s1 == s2: "+ (s1 == s2)); // 다른 객체, 참조 주소 다름

        Student s3 = s2; //s3에 s2가 가지고 있는 주소 복사
        s3.name="park";
        s3.study();

        s2.study(); //s3과 같은 주소로 참조
        System.out.println("s2 == s3: "+ (s2 == s3));
        
        /*
        s1=null; //값 비우기, 참조 끊김->자원 접근 불가로 오류 발생
        s1.study();
        */
        
        Student s4 = new Student(); // 내부에서 객체 생성, 생성자 함수의 멤버 변수 초기화
        s4.study();
    }
}
