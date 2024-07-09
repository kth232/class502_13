package exam01;

import config.AppCtx;
import member.entities.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex01 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test01() {
        String sql = "INSERT INTO MEMBER (SEQ, EMAIL, PASSWORD, USER_NAME) " +
                " VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, "user03@test.org", "123456", "user03");

        System.out.println(result);
    }

    @Test
    void test02() {
        List<Member> members = jdbcTemplate.query("SELECT * FROM MEMBER", this::mapper);
        //최대한 짧게 작성->람다식(함수형 인터페이스)
        /*
            (rs, num) -> { 
                Member.builder()
                        .seq(rs.getLong("SEQ"))
                        .email(rs.getString("EMAIL"))
                        .password(rs.getString("PASSWORD"))
                        .userName(rs.getString("USER_NAME"))
                        .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                        .build();
                        });
              */

        members.forEach(System.out::println);
    }

    @Test
    void test03() {
        String email = "user05@test.org";
        try {
            Member member = jdbcTemplate.queryForObject("SELECT * FROM MEMBER WHERE EMAIL = ?", this::mapper, email);
                /*
                (rs, num)->
                Member.builder()
                        .seq(rs.getLong("SEQ"))
                        .email(rs.getString("EMAIL"))
                        .password(rs.getString("PASSWORD"))
                        .userName(rs.getString("USER_NAME"))
                        .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                        .build(), email);
                 */

            System.out.println(member);
        } catch (Exception e) {
            System.out.println("no exist");
        }
    }
    
    @Test
    void test04() {
        int total= jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", int.class); //자료형 명시
        //값이 없으면 0이 나오기 때문에 예외 처리 안해도 됨
        System.out.println(total);
    }

    private Member mapper(ResultSet rs, int num) throws SQLException {
        return Member.builder()
                .seq(rs.getLong("SEQ"))
                .email(rs.getString("EMAIL"))
                .password(rs.getString("PASSWORD"))
                .userName(rs.getString("USER_NAME"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build();
    }
}
