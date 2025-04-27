package study;

import board.BoardData;
import config.AppCtx;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@SpringJUnitConfig(AppCtx.class)
public class Ex01 {

    @Autowired
    private DataSource dataSource;

    @Test
    void test1() {
        String sql = "SELECT * FROM BOARD_DATA";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while(rs.next()) {
                long seq = rs.getLong("SEQ");
                String poster = rs.getString("POSTER");
                String subject = rs.getString("SUBJECT");
                String content = rs.getString("CONTENT");
                LocalDateTime createdAt = rs.getTimestamp("CREATED_AT").toLocalDateTime();

                BoardData item = BoardData.builder()
                        .seq(seq)
                        .poster(poster)
                        .subject(subject)
                        .content(content)
                        .createdAt(createdAt)
                        .build();
                System.out.println(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}