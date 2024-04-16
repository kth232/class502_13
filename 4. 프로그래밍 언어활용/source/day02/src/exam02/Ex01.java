package exam02;

public class Ex01 {//exam02.Ex01
    public static void main(String[] args) {
        Schedule s1 = new Schedule();
        //s1.year = 2024;
        //s1.month = 2; //변수에 직접 대입->바로 메모리에 저장됨
        //s1.day = 31; // 지양->통제 불가

        s1.setYear(2024);
        s1.setMonth(2);
        s1.setDay(31); //통제 가능성o, 함수를 통해 값 들어오면 제어 가능해짐

        int month = s1.getMonth(); //값 조회
        System.out.println(month);

        s1.showDate();
    }
}