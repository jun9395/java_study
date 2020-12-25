public class PriorityTest {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

//        System.out.println(t1.getPriority());
//        System.out.println(t2.getPriority());
        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}


class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("*");
        }
    }
}


class Thread2 extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("/");
        }
    }
}