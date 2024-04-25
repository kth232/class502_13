package exam03;

public class Ex02 {
    public static void main(String[] args) {
        String fileName = "image.png";
        String extension = fileName.substring(6); //6번째 자리 이후부터 문자열 추출
        System.out.println(extension);
        String str = fileName.substring(2, 5); //2, 3, 4 시작기준부터 종료기준 미만까지
        System.out.println(str);
        /*
        String extension2 = fileName.substring(-1);
        System.out.println(extension2);
        // 일반적으로 뒤에서부터 추출할 땐 -1부터 역산, 안되는 언어도 있다..
         */
    }
}
