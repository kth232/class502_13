package exam02;

import org.choongang.configs.AppCtx;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringJUnitConfig(AppCtx.class)
@Transactional //  테스트가 종료되면 반영된 데이터가 ROLLBACK 된다.
public class Ex01 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test1() {
        String sql = "SELECT * FROM member WHERE email=?";
        Member member = jdbcTemplate.queryForObject(sql, (rs, i) -> {
            Member item = new Member();
            item.setSeq(rs.getLong("seq"));
            item.setEmail(rs.getString("email"));
            item.setName(rs.getString("name"));
            item.setPassword(rs.getString("password"));
            item.setMobile(rs.getString("mobile"));
            item.setTerms(rs.getBoolean("terms"));
            item.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
            return item;
        }, "user03@test.org");

        System.out.println(member);
    }

    @Test
    void test2() {
        String sql = "INSERT INTO member (email, password, name, mobile, terms) " +
                " VALUES (?, ?, ?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql, "user05@test.org", "12345678", "사용자05", "01010001000", 1);
        System.out.println(affectedRows);
    }

    @Test
    void test3() {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO member (email, password, name, mobile, terms) " +
                " VALUES (?, ?, ?, ?, ?)";
        int affectedRows = jdbcTemplate.update(con -> {
            PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"seq"});
            pstmt.setString(1, "user04@test.org");
            pstmt.setString(2, "12345678");
            pstmt.setString(3, "사용자03");
            pstmt.setString(4, "01010001000");
            pstmt.setBoolean(5, true);
            return pstmt;
        }, keyHolder);

        Number key = keyHolder.getKey();
        long seq = key.longValue();
        System.out.println("회원번호(seq):" + seq);
    }
}
