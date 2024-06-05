package exam01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Ex03Test {
    @TempDir
    private File tempDir;

    @Test
    void test1() {
        String path = tempDir.getAbsolutePath(); //파일 절대경로 찾기
        System.out.println(path);
    }
    @Test
    //@Timeout(3) //시간 제한 내에 테스트를 끝내야 하는 경우 사용, 기본: 초단위
    @Timeout(value = 2500, unit = TimeUnit.MILLISECONDS) //단위 세부설정 가능
    void test2() throws Exception {
        //시간 제한 이내 수행되면 테스트 통과
        Thread.sleep(2000);
    }
}
