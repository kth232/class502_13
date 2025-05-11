package org.choongang.global.member.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
public class Member {

    @Id
    private Long seq;
    private String email;
    private String password;
    private String name;
    private String mobile;

    @Column("isAdmin")
    private boolean isAdmin;
    private boolean terms;

    @Column("regDt") // 매핑 컬럼명 알려주는 것
    private LocalDateTime regDt; // reg_dt
}
