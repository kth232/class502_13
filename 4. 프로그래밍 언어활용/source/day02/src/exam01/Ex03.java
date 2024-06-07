package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Student s1 = new Student(202411, "lee", "java"); //매개변수만 입력, 인텔리제이에서 변수명에 대한 힌트 제공,,
        s1.study(); // 객체가 먼저 생성되어야 함수가 실행될 수 있다
        System.out.println(System.identityHashCode(s1)); //변수의 가상주소 출력

        Student s2 = new Student(202412, "kim", "react"); //새로운 다른 객체를 생성, 입력받는 값에 따라 다르게 출력
        s2.study();
        System.out.println(System.identityHashCode(s2));
    }
}
