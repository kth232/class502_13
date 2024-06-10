package exam01;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class Ex01Test {
    @Test
    void test1() {
        // 정적 상수 Locale.KOREAN 가능
        //Faker faker = new Faker(new Locale("ko_kr")); //한국어_한국 가짜 데이터
        Faker faker = new Faker(Locale.FRANCE);
        String name = faker.name().fullName(); //국가별 가짜 데이터 무작위 생성
        System.out.println(name);
    }

    @Test
    void test2() {
        Faker faker = new Faker(Locale.KOREAN);
        String address = faker.address().zipCode() + " " + faker.address().cityName() + faker.address().streetAddress();
        String addressSub = faker.address().secondaryAddress();
        System.out.println(address + " "+ addressSub);
    }
}
