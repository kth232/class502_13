package exam02;

public class Schedule2 {
    private int year;
    private int month;
    private int day;

    public Schedule2() { //기본 생성자
        this(2024, 6, 6); // 이미 만들어진 생성자 메서드를 찾아서 불러옴, 항상 첫번쩨 줄에 정의되어야 함
    }
    
    public Schedule2 (int year, int month, int day){ //생성자 오버로드
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    //인텔리제이 자동완성 편의기능 generate ->getter and setter
    public int getYear() {
        return year;
    }

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
        return this.day; //원래 this가 붙어있지만 출처가 명확한 경우 생략 가능함
    }

    public void setDay(int day) { //인스턴스 메서드: 객체가 된 후 접근 가능한 메서드
        this.day = day; //this: 메서드 내부에서 객체에 접근하기 위한 지역변수
    }

    public Schedule2 getThis() {
        return this;
    }

    //인텔리제이 자동완성 편의기능 generate ->toString()
    @Override
    public String toString() {
        return "year=" + year +
                ", month=" + month +
                ", day=" + day;
    }
}
