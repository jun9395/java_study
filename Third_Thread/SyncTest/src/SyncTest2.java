public class SyncTest2 {
    public static void main(String[] args) {
        Thread2 t = new Thread2();
//        Thread2 t2 = new Thread2();
//
//        t1.setName("T1");
//        t2.setName("T2");
//
//        t1.start();
//        t2.start();


        // 쓰레드를 상속받은 객체를 하나 생성하고,
        // 별도의 2개의 쓰레드를 만들어서 동시에 돌리는 경우
        Thread t1 = new Thread(t, "T1");
        Thread t2 = new Thread(t, "T2");

        t1.start();
        t2.start();
    }
}


class Thread2 extends Thread {
    public void run() {
        synchronized (this) {   // 쓰레드를 상속받은 클래스를 넣는다. 이 경우에는 자기 자신이므로 this
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}