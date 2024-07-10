package mappers.member;

import member.entities.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    //간단한 쿼리는 인터페이스로도 가능, 복잡한 쿼리는 매퍼를 만들어야 함
    @Select("SELECT COUNT(*) FROM MEMBER")
    long getTotal();

    int register(Member member);
    Member get(String email);
    int exists(String email);
}
