package exam02;

import java.util.HashMap;

public class Ex01 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>(); //순서는 고려x
        members.put("user01", "user01");
        members.put("user02", "user02");
        members.put("user03", "user03");
        members.putIfAbsent("user03", "mod_user03"); //key가 없을 때만 value값 추가
        members.putIfAbsent("user04", "user04");

        HashMap<String, String> members2 = new HashMap();
        members2.put("user05", "user05");
        members2.put("user06", "user06");
        members.putAll(members2); //members에 members2 추가됨

        //members.replace("user05", "mod_user05"); //수정
        members.put("user05", "mod_user05");
        members.remove("user05");

        String userNm =members.get("user03"); // 해당 키의 값 추출
        System.out.println(userNm);

        String userNm2 =members.getOrDefault("user07", "none"); // 키 없을 때 기본값으로 대체
        System.out.println(userNm2);

        System.out.println(members); //members.toString()
    }
}
