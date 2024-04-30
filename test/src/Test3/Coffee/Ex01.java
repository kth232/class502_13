package Test3.Coffee;

public class Ex01 {
    public static void main(String[] args) {
        Starbucks starbucks = new Starbucks();
        Coffeebean coffeebean = new Coffeebean();

        Person kim = new Person("kim", 10000);
        Person lee = new Person("lee", 5000);

        kim.setMenu("americano");
        lee.setMenu("latte");

        try{
            starbucks.enter(kim).order().exit();
            coffeebean.enter(lee).order().exit();
            System.out.println(kim);
            System.out.println(lee);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--카페별 매출액--");
        CoffeeShop.showSaleSummary(starbucks);
        CoffeeShop.showSaleSummary(coffeebean);
    }
}
