package exam01.member.dao;

import exam01.config.ManualBean;
import exam01.member.entities.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@ManualBean
@Component //service도 가능하지만 구성요소의 특징이 강하기 때문에 component로 설정
public class MemberDao { //memberDao = 빈 이름(자동 스캔 시 클래스명이 빈 이름이 됨)
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
