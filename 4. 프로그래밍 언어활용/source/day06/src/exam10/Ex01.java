package exam10;

public class Ex01 {
    public static void main(String[] args) {
        Outer out =new Outer();
        Calculator cal= out.method(40); //인터페이스도 객체가 됨, 지역변수 상수화
        int result = cal.add(10, 20); //자원 접근 가능 , 10+20+40
        System.out.println(result);

        int result2 = cal.add(20, 30); //지역변수가 호출이 끝났음에도 사라지지 않음, 20+30+40
        System.out.println(result2);
    }
}
