package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Transportation tran1 = Transportation.BUS; //정적 상수 객체(변수, 함수)
        Transportation tran2 = Transportation.BUS;
        System.out.println(tran1==tran2);
    }
}
