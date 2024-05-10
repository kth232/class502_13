package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //%d(정수), %f(실수), %s(문자열), %c(문자)
        /**
         * %자리수s: 자리수만큼 왼쪽 남은 자리를 공백으로 채운다 ex) %5s-> ___ab
         * %-자리수s: 자리수만큼 오른쪽 남은 자리를 공백으로 채운다 ex) %-5s ab___
         *
         */
        System.out.print("---");
        System.out.printf("%8s", "ab");
        System.out.println("---");

        System.out.print("---");
        System.out.printf("%-8s", "ab");
        System.out.println("---");

        System.out.print("-----");
        System.out.printf("%05d", 100); //공백 대신 0 채워넣기
        System.out.println("-----");
    }
}
