package exam01;

public class Student {
    int id; //학번
    String name; //변수 정의
    String subject; //변수 정의
    //정의만 하는 것은 의미 없음, 객체를 만들 때 이런 게 필요하다는 것만 명세해놓은 상태
    //실제 객체를 만들어야 의미를 가짐(최종 결과물=메모리 할당)

    void study() {
        System.out.printf("%s studies %s %n", name, subject);
    }

    public static void main(String[] args) {
        Student s1 = new Student(); //s1=지역변수
        s1.id = 20240101; //메모리를 할당받고 실체가 된 객체=인스턴스
    }
}
