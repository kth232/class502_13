package exam04;

import java.security.Provider;

public class Ex01 {
    public static void main(String[] args) {
        Order order = new Order();
        order.buy();
        order.sell();

        Buyer buyer = order; //다형성 가능
        buyer.buy();

        Seller seller = order;
        seller.sell();
    }
}
