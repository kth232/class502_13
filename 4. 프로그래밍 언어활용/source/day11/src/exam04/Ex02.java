package exam04;

import java.util.Stack;

public class Ex02 {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("name1");
        names.push("name2");
        names.push("name3");

        System.out.println(names.pop()); //name3
        System.out.println(names.pop()); //name2
        System.out.println(names.pop()); //name1
    }
}
