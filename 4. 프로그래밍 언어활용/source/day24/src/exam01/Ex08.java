package exam01;

public class Ex08 {
    public static void main(String[] args) throws InterruptedException{
        Ex08_1 th1 = new Ex08_1("*");
        Ex08_1 th2 = new Ex08_1("##");
        Ex08_1 th3 = new Ex08_1("&&&");

        th1.start();
        th2.start();
        th3.start();

        Thread.sleep(2000);
        th1.suspend(); //일시정지

        Thread.sleep(2000);
        th2.suspend(); //일시정지

        Thread.sleep(3000);
        th1.stop(); //완전 정지=종료
        th2.stop(); //종료

        Thread.sleep(2000);
        th3.stop(); //종료
    }
}

class Ex08_1 implements Runnable {
    //캐시 메모리에 임시 저장하여 연산, 각 캐시에 다른 값이 들어있으면 정확한 상태값을 읽어오지 못함->값 불일치
    //멀티 코어여서 캐시 메모리가 여러개->ram 메모리에서 확인하라고 알려줘야 함->volatile
    private volatile boolean stopped = false; //정지x
    private volatile boolean suspended = false; //일시정지x

    private Thread th;
    public Ex08_1(String name) {
        th = new Thread(this, name);
        //메서드 통제 위해 내부에서 스레드 객체 생성, name은 스레드명
    }

    @Override
    public void run() {
        while(!stopped) { //완전 정지 상태 통제
            if (!suspended) {//일시정지 상태 통제
                System.out.println(th.getName()); //스레드명 출력
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){} //시간 지연 취소?
            }
        }
    }
    //기본 구현된 메소드는 데드락 가능성이 있기 때문에 재정의함
    public void start() {
        th.start();
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
    }
}