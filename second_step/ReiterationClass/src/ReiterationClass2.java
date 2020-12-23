public class ReiterationClass2 {
    public static void main(String[] args) {
        Outer2.Inner2 inner = new Outer2.Inner2();
        inner.innerMethod2();
    }
}

class Outer2 {
    int outer2 = 10;
    static int outer22 = 20;

    void outerMethod2() {
        System.out.println("Outer2의 메서드입니다");
    }

    static class Inner2 {
        int inner2 = 20;

        void innerMethod2() {
            System.out.println("Inner2의 메서드입니다");
//            System.out.println(outer2);
            System.out.println(outer22);
        }
    }
}