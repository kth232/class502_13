package exam02;

public class Schedule {
    private int year; //멤버변수 정의
    private int month;
    private int day; //통제가 안되면 막는 게 좋다

    public void setYear(int _year) {
        year = _year;
    }// 반환값 없음

    public int getYear() {
        return year;
    }

    public void setMonth(int _month) {
        month = _month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int _day) {
        if (month ==2 && _day>28) {
            _day=28;
        }
        day = _day;
    }
    public int getDay() {
        return day;
    }

    void showDate() {
        System.out.printf("year:%d, month:%d, day:%d \n", year, month, day);
    }
}
