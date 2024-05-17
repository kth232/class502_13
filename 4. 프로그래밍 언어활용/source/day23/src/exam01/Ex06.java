package exam01;

public class Ex06 {
    private static boolean autoSave = false;

    public static void main(String[] args) throws InterruptedException{
        Thread th = new Thread(()->{
            while(true) { //무한루프
                try {
                    Thread.sleep(3000); //3초 지연
                } catch (InterruptedException e) {

                }
                System.out.println("Save");
            }
        });

        th.setDaemon(true); //현재 작업 중인 스레드가 종료됨->함께 종료, 메인 스레드보다 먼저 시작
        th.start();

        for (int i = 1; i <= 10; i++){
            Thread.sleep(1000);
            System.out.println(i);
            if (i == 3){
                autoSave = true; //3초마다 자동 저장 활성화
            }
        }
    }
}
