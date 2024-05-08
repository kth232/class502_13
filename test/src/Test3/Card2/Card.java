package Test3.Card2;

public class Card {
    private static int num;
    private int cardNum;
    private String holder;

    public Card(String holder){
        this.holder = holder;
        cardNum = ++num;
    }
    public String toString() {
        return String.format("cardNO: %d, holder: %s\n", cardNum, holder);
    }
}
