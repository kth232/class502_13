package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "kim", "java");
        Student s2 = new Student(1010, "lee", "react");

        System.out.println("s1: "+s1); // s1.id = 1000
        System.out.println("s2: "+s2); // s2.id = 1001

        System.out.println(s1.id); // Student.id
        System.out.println(s2.id); // Student.id

        s1.instanceMethod();
    }
}
