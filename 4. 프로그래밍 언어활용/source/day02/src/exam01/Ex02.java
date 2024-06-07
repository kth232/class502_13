package exam01;

public class Ex02 {
    public static void main(String[] args) { //메인함수는 정의된 모든 로직 수행이 끝날 때까지 대기 상태
        int n1 = 10; //전역변수, 변수명은 같아도 정의된 지역이 다르면 다른 변수임
        int n2 = 20;
        int r = add(n1, n2);
        System.out.println("add: "+ r);

        int y = calc(3);
        System.out.println("calc: "+ y);
    }
    public static int add (int n1, int n2) { //반환값 자료형 명시해야 함, 지역변수
        int result = n1 + n2; // 함수 실행 시 스택 영역에서 메모리 할당 받음(임시 메모리이기 때문에 연산 종료 시 메모리 제거=자원 해제)
        return result; //return: 함수가 연산을 끝냄
    }
    public  static int calc (int x) {
        int y = x * 2 + 1;
        return y;
    }
}
