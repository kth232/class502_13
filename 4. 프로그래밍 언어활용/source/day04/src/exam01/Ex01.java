package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Board b1=Board.getInstance(); // 내부에 만들어진 객체 공유->주소 동일
        Board b2=Board.getInstance();
        System.out.println(b1==b2);
        System.out.println("b1 adress: "+ System.identityHashCode(b1));
        System.out.println("b2 adress: "+ System.identityHashCode(b2));
    }
}
