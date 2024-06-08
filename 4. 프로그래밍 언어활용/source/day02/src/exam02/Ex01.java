package exam02;

public class Ex01 {//exam02.Ex01
    public static void main(String[] args) {
        Schedule s1 = new Schedule(); //생성자 함수
        //s1.year = 2024;
        //s1.month = 2; //멤버변수에 직접 대입->바로 메모리에 저장됨
        //s1.day = 31; //통제 불가->지양하는 방식

        s1.setYear(2024);
        s1.setMonth(2);
        s1.setDay(31); //통제 가능, 함수를 통해 값 들어오면 제어 가능해짐

        int month = s1.getMonth(); //값 조회
        System.out.println(month);

        s1.showDate();

        Schedule2 s2 = new Schedule2();
        s2.setYear(2024);
        s2.setMonth(6);
        s2.setDay(8);

        System.out.println(s2); //s2.toString(); 재정의 ->값을 확인해보기 위함

        Schedule2 _this = s2.getThis();
        System.out.println(_this == s2); //true

        Schedule2 s3 = new Schedule2(2024, 6, 7);
        System.out.println(s3); //s3.toString();

        Schedule2 s4 = new Schedule2();
        System.out.println(s4);


    }
}