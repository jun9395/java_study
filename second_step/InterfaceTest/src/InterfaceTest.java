public class InterfaceTest {
    public static void main(String[] args) {
//        InterA a = new InterA();    // 인터페이스로는 객체 생성 불가능
        TestClass t = new TestClass();

        t.methodA();
        t.methodB();

//        t.a = 100;  // static final이라 불가능

        System.out.println(t.a);
        System.out.println(t.b);


        // 인터페이스형 참조 변수 ia, ib
        InterA ia = new TestClass();
        InterB ib = new TestClass();

        ia.methodA();
        ib.methodB();


        // 변수에 직접 접근은 가능
        System.out.println(InterA.a);
        System.out.println(InterB.b);
    }
}


class TestClass implements InterA, InterB {

    @Override
    public void methodA() {
        System.out.println("interA의 메서드");
    }

    @Override
    public void methodB() {
        System.out.println("interB의 메서드");
    }
}


class TestClass2 implements InterC {
    // 자동으로 A까지 구현하라고 한다
    @Override
    public void methodA() {
        
    }

    @Override
    public void methodC() {

    }
}