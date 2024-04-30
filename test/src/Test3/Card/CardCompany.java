package Test3.Card;

public class CardCompany {
    private static CardCompany instance; //인스턴스 자원 정의

    private CardCompany() {} //private 기본 생성자, 외부 생성 통제
    public static CardCompany getInstance() { //외부 접근 가능하게
        if(instance == null ) //필요할 때 생성
            instance = new CardCompany();
        return instance;
    }
    public Card createCard() {

        Card card = new Card();
        return card;
    }
}
