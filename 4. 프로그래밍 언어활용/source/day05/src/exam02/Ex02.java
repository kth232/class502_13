package exam02;

public class Ex02 {
    public static void main(String[] args) {

        C c = new C();
        A a = c;
        B b = c;
        //System.out.println(c.numB);

        //A a =new C(); //A 클래스 변수 a에 C클래스 객체 생성
        System.out.println("c: "+System.identityHashCode(c));
        System.out.println("a: "+System.identityHashCode(a));
    }
}
