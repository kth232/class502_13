package Test3.Coffee;

public class Person {
    private String name; //고객명-조회
    private int money; //소지금-차감
    private String menu; //메뉴-확인

    public Person(String name, int money){
        this.name= name;
        this.money=money;
    }

    public String getName(){
        return name;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money= money;
    }
    public String getMenu() {
        return menu;
    }
    public void setMenu(String menu) {
        this.menu = menu;
    }
    public  String toString() {
        return String.format("%s님의 잔액은 %d원입니다.%n", name, money);
    }
}
