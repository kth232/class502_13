package exam01;

public class Student {
    int id; //학번
    String name; //이름
    String subject; //과목

    public Student() {
        // 기본 생성자(default 생성자) 함수, 생성자는 필수로 있어야 하는 함수이기 때문에 별도 입력 없을 시 컴파일러가 자동으로 만들어줌, 내부적으로 객체 정의되어 있음
        //->객체 생성이 목적이기 때문에 반환값 정의 x, 객체 접근 수단으로 객체의 주소값을 반환함
        // 객체가 생성된 이후 실행할 코드 작성 ->인스턴스 변수는 이미 생성된 상태임
        id = 202400; //멤버변수의 초기화를 주로 정의함
        name = "first";
        subject = "major";
    }

    public Student(int _id, String _name, String _subject) { //띄어쓰기 주의, 지역변수-스택에 할당
        // 생성자 오버로드
        // 객체가 생성된 이후 실행할 코드
        // 실행 시점? id, name, subject에 공간을 할당 받은 상태
        //System.out.println("객체 생성 이후 실행됨");
        // 인스턴스 변수의 초기화 작업을 주로 수행한다.
        id = _id;
        name = _name; //힙 영역에 할당
        subject = _subject; //할당받는 변수로 초기화
        /*
        id=202400;
        name="first";
        subject="major";
        */
    }

    void study() { //내부 수행하고 종료될 시 void(비어있다)->자료형 명시하지 않음
        // 객체 생성->호출->
        System.out.printf("id: %d, name: %s, subject: %s\n", id, name, subject);
        
        return; //리턴 시 함수 수행 종료됨, 아래 로직은 수행하지 않음
 
        //System.out.println("여기는 실행 안됨..");
    }
}
