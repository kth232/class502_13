package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex05 {
    public static void main(String[] args) {
        String[] names = {"name1", "name2", "name3", "name2", "name4", "name5"};
        List<String> namesList = Arrays.stream(names)
                //.collect(Collectors.toList());
                        .toList(); //사용 빈도 높다
        System.out.println(namesList);
        Set<String> namesSet = Arrays.stream(names)
                .collect(Collectors.toSet());
        System.out.println(namesSet); //중복 제거
    }
}
