package Test3.Coffee;

public interface CoffeeShop { //메서드 체이닝
    CoffeeShop enter(Person person); //입장
    CoffeeShop order(); //주문
    void exit(); // 퇴장
    int getTotalSalePrice();
    String getName();
    static void showSaleSummary(CoffeeShop Shop) {
        System.out.printf("%s의 총 매출액은 %d원 입니다.%n", Shop.getName(), Shop.getTotalSalePrice());
    }
}
