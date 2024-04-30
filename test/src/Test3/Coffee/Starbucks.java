package Test3.Coffee;

import java.util.HashMap;
import java.util.Map;

public class Starbucks extends AbstractCoffeeShop{
    private static Map<String, Integer> menus; // 정적으로 메뉴 정의

    static {
        menus = new HashMap<>();
        menus.put("americano", 4100);
        menus.put("latte", 4600);
    }

    public Starbucks() {
        super("Starbucks", menus); //생성자
    }
}
