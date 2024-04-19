package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Animal[] animals = {new Human(), new Bird(), new Tiger()}; // 동시에 생성하면서 배열 할당
        /*  위와 같음
        Animal[] animals = new Animal[3];
        animals[0]=new Human();
        animals[1]=new Bird();
        animals[2]=new Tiger();
         */
        for (Animal animal: animals) {
            animal.move();
            if (animal instanceof Human) { //출처 체크해보고 안전하게 바꾸기
                Human human = (Human) animal;//강제 형변환
                human.reading(); //원래 있던 자원도 접근 가능
            } else if (animal instanceof Tiger) { //downcasting
                Tiger tiger = (Tiger) animal;
                tiger.hunting();
            }
        }
    }
}
