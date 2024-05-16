package exam01;

import java.io.File;
import java.io.IOException;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/fstudy/sub1/sub2/sub3/test1.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);// 절대 경로

        // D:/fstudy/test1.txt
        File file2 = new File("D:/fstudy/sub1/sub2/sub3/../../../test1.txt");
        String absolutePath2 = file2.getAbsolutePath();
        System.out.println(absolutePath2);
        String canonicalPath = file2.getCanonicalPath();
        System.out.println(canonicalPath); //정규화된 파일 경로

        System.out.println("getName(): "+file.getName()); //파일명만 출력
        System.out.println("getPath(): "+file.getPath()); //파일 경로 출력

    }
}
