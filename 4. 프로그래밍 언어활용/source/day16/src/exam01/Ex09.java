package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex09 {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1, "lee", 80),
                new Student(1, "kim", 60),
                new Student(1, "park", 75),

                new Student(2, "lee", 100),
                new Student(2, "kim", 90),
                new Student(2, "park", 50),

                new Student(3, "lee", 65),
                new Student(3, "kim", 95),
                new Student(3, "park", 55)
        };
        Map<Boolean, List<Student>> data = Arrays.stream(students)
                .collect(Collectors.partitioningBy(s->s.getScore()>=70));
        List<Student> students1 = data.get(true);//70점 이상인 학생 목록
        students1.forEach(System.out::println);

    }
}
