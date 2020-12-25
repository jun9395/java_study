public class SyncTest1 {
    public static void main(String[] args) {
        DataClass d = new DataClass();

        Thread1 t1 = new Thread1(d);
        Thread1 t2 = new Thread1(d);
        t1.setName("T1");   // t1 쓰레드의 name을 T1으로 저장
        t2.setName("T2");

        t1.start();
        t2.start();
    }
}


class Thread1 extends Thread {
    DataClass dc;

    public Thread1(DataClass dc) {
        this.dc = dc;
    }

    public void run() {
        dc.method(Thread.currentThread().getName());    // 현재 쓰레드의 이름 가져오기
    }
}


class DataClass {
    public synchronized void method(String name) {   // 쓰레드에 이름 붙이기
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
            System.out.println(name + " : " + i);
        }
    }
}