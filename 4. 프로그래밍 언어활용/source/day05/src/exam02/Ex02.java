package exam02;

public class Ex02 {
    public static void main(String[] args) {

        C c = new C(); //c객체 생성
        A a = c; //하위 클래스가 상위 클래스의 자료형으로 자동 형변환(다형성)
        B b = c; //B클래스형으로 형변환(업캐스팅)
        System.out.println(c.numB); //상위 클래스 자원 사용 가능

        //A a =new C(); //A 클래스형 변수 a에 C클래스 객체 생성
        System.out.println("c: "+System.identityHashCode(c));
        System.out.println("a: "+System.identityHashCode(a));
        System.out.println("b: "+System.identityHashCode(b));
    }
}
