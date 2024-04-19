package exam03;

import exam02.B;

public class Ex01 {
    public static void main(String[] args) {
        
        Human human = new Human(); //Aniamal class도 가능
        //human.move();

        Tiger tiger = new Tiger(); //Tiger, Animal
        //tiger.move();

        Bird bird = new Bird(); // Bird, Animal
        //bird.move();

        Animal[] animals= new Human[3];
        animals[0]=human; // Animal animals[0]=human;
        animals[1]=tiger; // Animal animals[1]=tiger;
        animals[2]=bird; // Animal animals[2]=bird;
        /*
        for(int i=0; i<animals.length;i++) {
            animals[i].move();
        }
        */

        for (Animal animal: animals) { //향상된 for문
            animal.move();
        }
    }
}
