package mappers;

import member.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {
    //추상메서드 정의->매퍼 파일과 동일한 경로 동일한 패키지명, 동일한 파일명으로 입력
    List<Member> getList();

    @Select("SELECT USER_NO userNo, USER_ID userId, USER_PW, USER_NM, MOBILE, REG_DT, MOD_DT FROM MEMBER")
    //별칭 형태로 명시해서 맞춰주면 매핑됨
    List<Member> getList2();

    List<Member> getList3(Member member);

    List<Member> getList4(List<String> userIds);

    List<Member> getList5(long userNo);

    int register(Member member);

    int register2(Member member); //알아서 구현되고 실행됨

    int modify(Member member);
    
    int delete(String userId); //변수명 동일해야 함

    @Delete("DELETE FROM MEMBER WHERE USER_ID = #{userId}")
    int delete2(String userId);
}
