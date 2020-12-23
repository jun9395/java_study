public class ReiterationClass1 {
    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner inner = out.new Inner();

        out.outerMethod();
        inner.innerMethod();
    }
}

class Outer {
    int outer1 = 10;

    void outerMethod() {
        System.out.println("Outer의 메서드입니다");
//        System.out.println(inner1); // 선언되지 않아서 사용 불가능하다
    }

    // 중첩클래스
    class Inner {
        int inner1 = 20;

        void innerMethod() {
            System.out.println("Inner의 메서드입니다");
            System.out.println(outer1);
        }
    }
}