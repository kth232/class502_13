package exam01;

import java.util.*;

public class Ex03 {
    public static void main(String[] args) {
        List<String> items = new ArrayList();
        print(items);

        Set<String> items2 = new HashSet<>();
        print(items2);
        //유연성, 다양한 활용성->다형성
    }
    public static void print(Collection<?> collection){ //어떤 것이 들어와도 상관x
        collection.forEach(System.out::println);
    }
}
