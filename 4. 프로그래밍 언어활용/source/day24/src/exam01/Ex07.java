package exam01;

public class Ex07 {

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(() -> { //집중할 부분
            Thread th2 = Thread.currentThread();
            while(true) {
                try {
                    System.out.println("isInterrupted:"+ th2.isInterrupted());
                    Thread.sleep(10000); //waiting-일시정지, 10초
                    // interrupted() -> InterruptedException 발생, isInterrupted ->false
                } catch (InterruptedException e) { // runnable-실행대기 <-3초 뒤 바뀜
                    System.out.println("InterruptedException 발생"); //바로 예외 발생->반응성 증가
                    th2.interrupt(); //interruptedException 예외 계속 발생
                }
            }
        });
        th.start();
        Thread.sleep(3000); //메인스레드 일시 정지
        th.interrupt(); //interruptedException 발생, isInterrupted ->true
    }
}
