package exam01;

public class Ex05 {
    public static void main(String[] args) {
        int total=0, num=0; //초기값, 동일한 자료형일 때 한꺼번에 여러 변수 선언 및 초기화 가능
        while(num<=100) { //조건식-반복을 멈추는 조건
            total+=num; //total= total +num;
            num++; //num = num + 1;
        } //증감식, 횟수가 정해져있는 반복문의 필수 요소 3가지
        System.out.println("total: "+total); //문자열+숫자 결합
    }
}
