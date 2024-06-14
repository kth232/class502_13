package exam01;

public class Student {
    static int serialNo = 1000; //일련번호, 정적 변수
    int id; //학번 변수 정의=공간의 이름
    String name; //이름
    String subject; //과목, 멤버 변수, 인스턴스 변수

    public Student() {
        // 기본 생성자(default 생성자) 함수, 생성자는 필수로 있어야 하는 함수이기 때문에 별도 생성 수단이 없을 시에만 컴파일러가 자동으로 만들어줌, 내부적으로 객체 정의되어 있음
        //->객체 생성이 목적이기 때문에 반환값 정의 x, 객체 접근 수단으로 객체의 주소값을 반환함, 변수 공간만 만들어짐
        // 객체가 생성된 이후 실행할 코드 작성 ->인스턴스 변수는 이미 생성된 상태임
        id = 202400; //멤버변수의 초기화를 주로 정의함
        name = "first";
        subject = "major";
        serialNo++; //객체 생성될 때마다 증가
    }

    public Student(int _id, String _name, String _subject) { //지역변수->스택에 저장
        // 생성자 오버로드: 시그니처가 다르기 때문에 이름은 같지만 다른 함수임
        // 객체가 생성된 이후 실행할 코드
        // 실행 시점? id, name, subject에 공간을 할당 받은 상태
        //System.out.println("객체 생성 이후 실행됨");
        // 지역변수는 실행될 때 인스턴스 변수에 값 할당
        this.id = _id;
        this.name = _name; //인스턴스 변수 ->힙 영역에 할당
        this.subject = _subject; //생성과 동시에 할당받는 변수로 초기화 수행
        Student.serialNo++; //객체 생성될 때마다 증가, 정적 변수=클래스 변수(클래스명으로 접근)
    }

    void study() { //내부 수행하고 종료될 시 void(비어있다)->자료형 명시하지 않음
        // 객체 생성->호출->
        System.out.printf("serialNo: %d, id: %d, name: %s, subject: %s\n", serialNo, id, name, subject);
        
        return; //리턴 시 함수 수행 종료됨, 아래 로직은 수행하지 않음
 
        //System.out.println("여기는 실행 안됨..");
    }

    public static void staticMethod() {
        System.out.println("static method");
        //this.name = 1000; //객체 생성과 관련x, this 존재 x
        //인스턴스 자원은 정적 메서드 접근 불가
        int serialNo = 100; // 정적 자원은 접근 가능
    }
}
