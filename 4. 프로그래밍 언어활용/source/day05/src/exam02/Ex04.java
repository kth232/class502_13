package exam02;

public class Ex04 {
    public static void main(String[] args) {
        A ad = new D(); //업캐스팅, 다형성, D객체를 생성하는데 A클래스 크기만큼 범위 한정
        A ac = new C(); //A 클래스형으로 C 객체 생성

        if (ad instanceof C) { //instanceof 연산자: 객체의 출처를 확인하는 연산자
            C c = (C) ad; // 객체 출처가 달라서 데이터 손상 등 문제가 생길 가능성이 있다면 상속 불가
        }
        if(ac instanceof C) {//다운캐스팅, 같은 출처라도 명확한 출처를 알려줘야함->명시적 형변환
            C cc = (C) ac;
            System.out.println(cc.numC);
        }
    }
}
