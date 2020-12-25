public class ThreadTest {
    // JVM은 main 메소드도 쓰레드로 돌린다
    public static void main(String[] args) {
        Thread1 t1 = new Thread1(); // Thread1는 쓰레드 객체이므로
        t1.start();

        Thread2 t2 = new Thread2();
        Thread t = new Thread(t2);  // Runnable 인터페이스를 구현한 객체를 인자로
        t.start();

        while (true) {
            try {
                Thread.sleep(1000); // 1000ms = 1s 쉬고 작동
            } catch (Exception e) {}
            System.out.println("*");
        }

//        while (true) {  // 위가 무한루프이므로 이 코드는 유효하지 않다
//            System.out.println("-");
//        }
    }
}


// Thread 클래스 상속
class Thread1 extends Thread {
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
            System.out.println("-");
        }
    }
}


// Runnable 인터페이스
class Thread2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println("/");
        }
    }
}