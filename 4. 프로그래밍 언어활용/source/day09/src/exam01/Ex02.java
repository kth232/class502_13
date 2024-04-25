package exam01;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); //터미널에 입력
        System.out.println("enter your name: ");
        String name= sc.nextLine();
        System.out.printf("name: %s%n", name);
    }
}
