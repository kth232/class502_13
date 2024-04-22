package exam04;

public class Order implements Buyer, Seller{
    @Override
    public void buy() {
        System.out.println("buy"); //메소드 재정의, 구현
    }

    @Override
    public void sell() {
        System.out.println("sell");
    }

    public void order() { //다중 상속 불가
        Buyer.super.order(); //Buyer의 order를 가져올 것을 명시
    }
}
