package Test3.Coffee;

import java.util.HashMap;
import java.util.Map;

public class Coffeebean extends AbstractCoffeeShop{
    private static Map<String, Integer> menus; // 정적으로 메뉴 정의

    static {
        menus = new HashMap<>();
        menus.put("americano", 3800);
        menus.put("latte", 4200);
    }

    public Coffeebean() {
        super("Coffeebean", menus); //생성자
    }
}
