package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex07 {
    public static void main(String[] args) {
        String[] names = {"name1", "name2", "name3", "name2", "name4", "name5"};

        ArrayList<String> items = Arrays.stream(names)
                .collect(Collectors.toCollection(ArrayList::new));
                //.collect(Collectors.toCollection(() -> new ArrayList<>()));
        System.out.println(items);
    }
}
