package exam01.member.dao;

import exam01.member.entities.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {
    private static Map<String, Member> members =new HashMap<>();

    public void register(Member member) { //DB가 아직 없어서 메모리에 저장해놓는 형태로 임시 처리
        members.put(member.getEmail(), member);
    }

    public Member get(String email) {
        return members.get(email);
    }

    public List<Member> getList() {
        List<Member> data = new ArrayList<>(members.values());

        return data;
    }
}
