package exam01;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("name1", "name2", "name3");
        List<String> fruits = Arrays.asList("apple", "orange", "melon");

        Stream<Stream<String>> stm = Stream.of(names.stream(),fruits.stream()); //스트림 중첩
        /*
        stm.forEach(st->{
            st.forEach(System.out::println);
        }); 
        */
        //stm.flatMap(s->s).forEach(System.out::println); //평탄화 작업: 일차원적 스트림으로 변환
        
        String[] strs = stm.flatMap(s->s).toArray(String[]::new);
        System.out.println(Arrays.toString(strs));
    }

}
