package exam02;

import java.util.stream.Stream;

public class Ex08 {
    public static void main(String[] args) {
        long cnt = Stream.of("name1", "name2", "name3").count(); // 일반 스트림 객체 생성
        System.out.println(cnt);
    }
}
