package exam01;

public class Student { //클래스: 객체를 만들기 위한 설계명세
    int id; //학번
    String name; //변수 정의
    String subject; //변수 정의
    //정의만 하는 것은 의미 없음, 객체를 만들 때 이런 게 필요하다는 것만 명세해놓은 상태
    //실제 객체를 만들어야 의미를 가짐(최종 결과물=메모리 할당)

    void study() { //void: 비어있다.=반환할 값이 없다.
        System.out.printf("id: %d, name: %s, subject: %s%n", id, name, subject);
    }
}
