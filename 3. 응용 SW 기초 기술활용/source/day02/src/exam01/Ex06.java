package exam01;

public class Ex06 {
    public static void main(String[] args) {
        int total=0;
        int i=0, j=10; //초기화식을 밖에 정의할 수 있음
        for (; i<=100; i++, j +=5) { //조건이 참일 때 반복 실행
            total += i;
            System.out.println("J: "+j);
        }
        System.out.println("total: "+total);
    }
}
