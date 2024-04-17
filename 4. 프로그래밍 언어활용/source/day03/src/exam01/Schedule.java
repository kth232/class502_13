package exam01;

public class Schedule {
    private int year;
    private int month;
    private int day;

    public Schedule () {
        this(2024, 4, 17); //생성자 메소드 내부 로직 수행
        //가장 첫번째 줄에서 정의해야 함
        /*
        year=2024;
        month=4;
        day=17;
         */
    }

    public Schedule(int year, int month, int day) {
        this.year = year; //힙의 멤버변수(인스턴스 변수)=스택의 지역변수
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    } //this.year에서 this 생략

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (this.month ==2 && day>28) {
            day=28;
        }
        this.day=day; //자바에서 this는 생략 가능, 명확하게 알려주고 싶을 때 입력
    }

    void showDate() {
        System.out.printf("year: %d, month: %d, day: %d \n", year, month, day);
        printThis(); //this.printThis()
    }

    public void printThis () {
        System.out.println(this);
    }

    public Schedule returnThis() {
        return this;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
