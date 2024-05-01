package Test3.Coffee2;

public class CoffeeTest {
    public static void main(String[] args) {

        Person kim = new Person("Kim", 10000);
        StarCoffee starCoffee = new StarCoffee();

        Person lee = new Person("lee", 10000);
        BeanCoffee beanCoffee = new BeanCoffee();

        kim.buyStarCoffee(starCoffee, 4000);
        lee.buyBeanCoffee(beanCoffee, 4500);

    }
}
