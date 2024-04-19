package exam02;

public class Ex03 {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c instanceof C);
        System.out.println(c instanceof B); //안에 포함되어 있으면 참
        System.out.println(c instanceof A);

        //System.out.println(C instanceof String);
    }
}
