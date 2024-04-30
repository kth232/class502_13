package exam02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex02 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>(); //순서는 고려x
        members.put("user01", "user01");
        members.put("user02", "user02");
        members.put("user03", "user03");

        Set<String> keys = members.keySet();
        Collection<String> values = members.values();
        System.out.println("keys: "+keys);
        System.out.println("values: "+values);
    }
}
