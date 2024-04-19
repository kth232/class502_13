package exam04;

public class Ex01 {
    public static void main(String[] args) {
        // Calculator cal = new Calculator(); //기능을 구현하지 않아서(기능적으로 불완전하기 때문에) 직접 객체 생성 제한됨, 내부적으로는 객체 생성됨
        Calculator scal = new SimpleCalculator(); //다형성 적용
        int result = scal.add(10, 20);
        System.out.println(result);
        System.out.println(scal.num); //추상메서드도 객체 생성되야 함->상속 가능
        //재정의는 인스턴스 메소드만 가능->객체가 만들어져야 가능함
        //상속과 오버라이딩은 객체 생성과 연관됨
        }
}
