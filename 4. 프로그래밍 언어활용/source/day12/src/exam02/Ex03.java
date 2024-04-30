package exam02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ex03 {
    public static void main(String[] args) { //순서 무시
        //HashMap<String, String> members = new HashMap<>();
        Map<String, String> members = new TreeMap<>(Comparator.reverseOrder()); //역순 정렬
        members.put("user01", "user01");
        members.put("user02", "user02");
        members.put("user03", "user03");
        members.put("user04", "user04");
        members.put("user05", "user05");

        //Set<Map.Entry<String, String>> entries = members.entrySet();

        for (Map.Entry<String, String> entry : members.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("id: %s, name: %s%n", key, value);
        }

    }
}
