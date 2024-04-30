package Test3.Coffee;

import java.util.Map;

public abstract class AbstractCoffeeShop implements CoffeeShop {
    private String name; //카페 이름
    private int totalSalePrice; //매출
    private Map<String, Integer> menus; //메뉴
    private Person person;

    public AbstractCoffeeShop(String name, Map<String, Integer> menus){
        this.name = name;
        this.menus = menus;
    }

    @Override
    public CoffeeShop enter(Person person) {
        this.person = person;
        System.out.printf("%s님이 %s에 입장하였습니다.%n", person.getName(), name);
        return this; //메서드 체이닝
    }
    @Override
    public CoffeeShop order() {
        String menu = person.getMenu();
        if (menu == null){
            throw new RuntimeException("메뉴를 선택하세요."); //예외 전가, 한번 끊어주는 것이 좋다
        }
        int price = menus.getOrDefault(menu, 0); //null값일 때 오류 발생할 수 있으므로 기본값 부여
        if (price ==0){
            throw new RuntimeException("없는 메뉴입니다."); // 예외 전가
        }

        int money = person.getMoney();
        if (money<price){
            throw new RuntimeException("잔액이 부족합니다.(잔액: "+(price-money)+")"); // 예외 던지기
        }

        totalSalePrice += price;
        money -= price;
        person.setMoney(money);

        System.out.printf("%s님이 %s에서 %s(가격: %s)를 주문했습니다.%n", person.getName(), name, menu, price);
        return this;
    }
    public void exit() {
        System.out.printf("%s님이 %s에서 퇴장하였습니다.%n", person.getName(), name);
        person = null;
    }

    public int getTotalSalePrice() {
        return totalSalePrice;
    }

    public String getName() {
        return name;
    }
}
