public class FinalTest {
    public static void main(String[] args) {
        TestClass1 c1 = new TestClass1();

//        c1.a = 300;
        System.out.println(c1.a);
    }
}

class TestClass1 extends TestClass2 {
    final int a = 100;

    public void method1() {
//        a = 200;
    }

//    public void method2() {
//        System.out.println("Overriding");
//    }
}

class TestClass2 {
    public final void method2() {
        System.out.println("final method");
    }
}


final class TestClass3 {

}

//class TestClass4 extends TestClass3 {}