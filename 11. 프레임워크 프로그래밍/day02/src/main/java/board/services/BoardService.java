package board.services;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BoardService implements InitializingBean, DisposableBean {
    //추상 메서드 정의됨, 설정 필수 항목
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()");
    } //객체 소멸 직전에 호출됨

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    } //초기화 단계 시 호출됨, 각 객체마다 출력

    public void write() {
        System.out.println("write");
    }
}
