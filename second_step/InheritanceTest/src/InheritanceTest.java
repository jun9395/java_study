public class InheritanceTest {
    public static void main(String[] args) {
        ChildClass1 pc1 = new ChildClass1();

        pc1.v1 = 100;
        pc1.method1();

        pc1.v2 = 200;
        pc1.method2();

        pc1.method3();
        System.out.println(pc1.v1);
    }
}
