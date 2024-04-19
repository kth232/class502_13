package exam02;

public class Student {
    private static int id; //정적 변수
    private String name="lee";
    private String subject;

    public Student(int id, String name, String subject) {
        this.id=id;
        this.name=name;
        this.subject=subject;
    }
    public static void staticMethod() { //객체와 상관없이 사용 가능, this 지역변수x->객체의 자원 접근x
        //정적 자원만 접근 가능(static 변수, 메서드)
        System.out.println("static method");
        //this.name = "이이름";
        //this.instanceMethod();
        id=1000;
    }

    public void instanceMethod() { //this 지역 변수o, 객체 자원 접근
        System.out.println("instance method");
        System.out.println(this.name);

        //정적 자원은 객체 생성 이전부터 존재
        staticMethod();
        id = 1000;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
