package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Ex08 {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1, "lee"),
                new Student(1, "kim"),
                new Student(1, "park"),

                new Student(2, "lee"),
                new Student(2, "kim"),
                new Student(2, "park"),

                new Student(3, "lee"),
                new Student(3, "kim"),
                new Student(3, "park")
        };
        /*
        Map<Integer, String> data = Arrays.stream(students) //Integer wrapper클래스 사용
                .collect(toMap(Student::getBan, Student::getName)); //코드가 길어질 것 같을 때 단어 클릭 후 alt+enter하면 static 형태로 사용
        System.out.println(data);
        */

        Map<Integer, List<Student>> data = Arrays.stream(students)
                .collect(Collectors.groupingBy(Student::getBan));
        List<Student> Students2 = data.get(2); //2반만 그룹핑
        Students2.forEach(System.out::println);
    }
}
