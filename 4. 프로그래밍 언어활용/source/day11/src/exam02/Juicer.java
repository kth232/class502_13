package exam02;

import java.util.ArrayList;

public class Juicer {
    // ? - Fruit, Apple, Grape
    public static void make(FruitBox<? extends Fruit> box) { //와일드 카드
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
    }

    // 지네릭 메서드, extends만 사용 가능, 간단하게 작성
    public static <T extends Fruit> void make3(FruitBox<T> box){

    }

    // ? -Apple, Fruit, Object
    public static void make2(FruitBox<? super Apple> box){
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
    }
}
