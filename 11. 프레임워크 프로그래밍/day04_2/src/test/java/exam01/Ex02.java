package exam01;

import org.choongang.board.BoardData;
import org.choongang.configs.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringJUnitConfig(AppCtx.class)
public class Ex02 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test1() {
        String sql = "SELECT * FROM BOARD_DATA WHERE BID = ? AND CATEGORY = ?";
        List <BoardData> items = jdbcTemplate.query(sql, this::mapper, "news", "소식");

        items.forEach(System.out::println);
    }

    @Test
    void test2() {
        String sql = "SELECT * FROM BOARD_DATA WHERE SEQ=?";
        BoardData item = jdbcTemplate.queryForObject(sql, this::mapper, 16L);
        System.out.println(item);
    }

    @Test
    void test3() {
        String sql = "SELECT COUNT(*) FROM BOARD_DATA";
        long total = jdbcTemplate.queryForObject(sql, long.class);
        System.out.println(total);
    }

    private BoardData mapper(ResultSet rs, int i) throws SQLException {
        return BoardData.builder()
                .seq(rs.getLong("SEQ"))
                .poster(rs.getString("POSTER"))
                .subject(rs.getString("SUBJECT"))
                .content(rs.getString("CONTENT"))
                .createdAt(rs.getTimestamp("CREATED_AT").toLocalDateTime())
                .build();
    }
}
