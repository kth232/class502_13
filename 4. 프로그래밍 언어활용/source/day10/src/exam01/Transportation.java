package exam01;

public enum Transportation { //enum 클래스(상수로 기능함), 추상클래스
    SUBWAY(1450){
        public int getTotal(int person) {
            return getFare() * person;
        }
    },
    BUS(1350){ //정적 상수 객체로 내부적으로 생성됨->메서드 정의 가능
        public int getTotal(int person) {
            return getFare() * person;
        }
    },
    TAXI(4800){ //상수명은 대문자로 쓰는 것이 관례
        public int getTotal(int person) {
            return getFare() * person;
        }
    };


    private final int fare; //상수((변경불가)로 정의(관례)

    Transportation(int fare){ //매개변수가 있는 생성자 함수
        this.fare=fare; //객체 자원이기 때문에 멤버 변수 가능, this 가능
    }
    public int getFare() { //상수들이 접근 가능한 메서드
        return fare;
    }
    public abstract int getTotal(int person); // 추상 메서드 정의
}

/* 내부적으로 컴파일러가 이렇게 바꿔줌
public abstract class Transportation extends java.lang.enum {
    public static final BUS = new Transportation();
    public static final SUBWAY = new Transportation();
    public static final TAXI = new Transportation();
}
 */