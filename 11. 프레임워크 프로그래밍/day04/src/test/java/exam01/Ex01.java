package exam01;

import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;

@Transactional //수동 관리->프록시, 자동 롤백
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex01 {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Test
    void test01() {
        KeyHolder keyHolder = new GeneratedKeyHolder(); // KeyHolder를 이용해서 키값 자동 생성
        /*
        int result= jdbcTemplate.update(new PreparedStatementCreator() { //넘겨주는 값이 커넥션 객체, 함수형 인터페이스->람다식
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException { //사용자가 만든 쿼리
                String sql = "INSERT INTO MEMBER(SEQ, EMAIL, PASSWORD, USER_NAME) " +
                        "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)";
         */
        int result = jdbcTemplate.update(con -> {String sql = "INSERT INTO MEMBER(SEQ, EMAIL, PASSWORD, USER_NAME) " +
                        "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)";

                PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"SEQ"});
                pstmt.setString(1, "user05@test.org");
                pstmt.setString(2, "123456");
                pstmt.setString(3, "user05");

                return pstmt;
        }, keyHolder);
        System.out.println(result);
        Number key = keyHolder.getKey(); //getKey()는 Number형->개발자가 적절한 숫자형으로 변환해서 사용
        long seq = key.longValue();
        System.out.println(seq);
    }
}
