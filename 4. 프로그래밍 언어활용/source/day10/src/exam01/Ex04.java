package exam01;

public class Ex04 {
    public static void main(String[] args) {
        Transportation trans = Transportation.TAXI;
        String str = trans.name(); //trans.toString() 상수 이름을 문자열로 변환
        System.out.println(str);

        int ordinal = trans.ordinal(); //상수의 위치번호
        System.out.println(ordinal);
    }
}
