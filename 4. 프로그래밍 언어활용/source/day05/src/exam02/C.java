package exam02;

public class C extends B{
    int numC= 30;
    public C() {
        //객체 만들 때 필수 요소, 따로 정의하지 않아도 없으면 컴파일러가 추가해줌
        super(); // B클래스에 정의된 B 생성자, 가장 첫번째 줄에 작성해야 함
        System.out.println("C 생성자");
    }
}
