package exam01;

import member.Board;
import member.Member;
import member.User;
import member.User2;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class Ex02 {
    @Test
    void test1() {
        Member member = new Member("user01", "user02");
        member.setEmail("user01@test.org");
        System.out.println(member);
    }

    @Test
    void test2() {
        Board board = new Board("title", "content");
        System.out.println(board);
    }

    @Test
    void test3() {
        User user = User.builder() //유저 객체를 만드는 빌더 객체?
                .userId("user01") //메소드체이닝 방식이라 순서 상관x, 일부만 입력해도 o
                .userNm("user01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .build();
        System.out.println(user);
    }

    @Test
    void test4() {
        User2 user = User2.builder()
                .userId("user01") //메소드체이닝 방식이라 순서 상관x, 일부만 입력해도 o
                .userNm("user01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .build();
        System.out.println(user);
        
        User2 user2 = new User2(); //기본 생성자 가능
    }
}
