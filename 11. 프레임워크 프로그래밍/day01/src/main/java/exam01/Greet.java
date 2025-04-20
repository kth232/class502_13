package exam01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Greet implements InitializingBean, DisposableBean {
    public void init() {
        System.out.println("init()");
    }

    public void close() {
        System.out.println("close()");
    }

    public void hello(String name) {
        System.out.printf("%s님 안녕하세요.%n", name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    }
}
