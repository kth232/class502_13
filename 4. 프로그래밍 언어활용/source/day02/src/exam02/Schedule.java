package exam02;

public class Schedule {
    private int year; //멤버변수 정의, 접근 제어
    private int month;
    private int day; //통제가 안되면 접근을 막는 게 좋다

    public void setYear(int _year) {
        year = _year;
    }//매개변수로 받은 값을 인스턴스 변수에 할당하는 메서드 정의

    public int getYear() {
        return year;
    }

    public void setMonth(int _month) {
        month = _month;
    }

    public int getMonth() {
        return month;
    } //값 조회하는 getter 메서드 정의

    public void setDay(int _day) {
        if (month == 2 && _day > 28) {
            _day = 28;
        }
        day = _day;
    } //함수 내부에서 값을 검증할 수 있음->통제 가능
    //함수 안으로 감춤->캡슐화, 정보은닉

    public int getDay() {
        return day;
    }

    void showDate() {
        System.out.printf("year:%d, month:%d, day:%d\n", year, month, day);
    }
}
