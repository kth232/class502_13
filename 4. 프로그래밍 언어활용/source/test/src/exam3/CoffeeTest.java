package exam3;

public class CoffeeTest {

    public static void main(String[] args) {

        Person kim = new Person("Kim", 10000);
        StarCoffee starCoffee = new StarCoffee();
        BeanCoffee beanCoffee = new BeanCoffee();

        kim.buyStarCoffee(starCoffee, 4000);
        kim.buyBeanCoffee(beanCoffee, 4500);


        Person lee = new Person("lee", 20000);
        starCoffee = new StarCoffee();
        beanCoffee = new BeanCoffee();

        lee.buyStarCoffee(starCoffee, 4000);
        lee.buyBeanCoffee(beanCoffee, 4500);
    }
}