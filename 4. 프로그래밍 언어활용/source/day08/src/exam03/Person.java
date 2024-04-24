package exam03;

public class Person {
    public int age; //지역변수1
    public String name; //지역변수2

    public Person() {} //기본 생성자
    public Person(int age, String name) {
        this.age=age;
        this.name=name;
    }

    public int getAge() { //메서드1
        return age;
    }

    public String getName() { //메서드2
        return name;
    }
}
