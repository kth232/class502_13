package exam03;

import javax.management.monitor.Monitor;

public class Desktop {
    private Monitor monitor;
    private Body body;
    private Keyboard keyboard;
    private Mouse mouse;
    private GraphicCard card;

    public Desktop(Monitor monitor, Body body, Keyboard keyboard, Mouse mouse, GraphicCard card) {
        this.monitor = monitor;
        this.body = body;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.card = card;
    }

    public void run() {
        body.run();
        // monitor, body, keyboard, mouse 등 구성 객체를 활용
        // desktop객체는 구성 객체 변화에 영향을 받는 관계
        // ->통제 필요->캡슐화: 폐쇄
    }
}
