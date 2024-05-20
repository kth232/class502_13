package exam01;

public class Ex05 {
    private static boolean autoSave = false;

    public static void main(String[] args) {
        Thread th = new Thread(()->{
        while(true) { //무한루프
            try {
                Thread.sleep(3000); //3초 지연
            } catch (InterruptedException e) {}

            if (autoSave) {
                System.out.println("save");
            }
        }
    });

    th.setDaemon(true); //현재 작업중인 스레드(메인)가 종료되면 th도 같이 종료
    th.start();

    for (int i = 1; i <= 10; i++) {
        Thread th2 = Thread.currentThread();
        System.out.println(th2.getName() + "-" + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){}

        if (i == 3) autoSave = true;
        }
    }
}
