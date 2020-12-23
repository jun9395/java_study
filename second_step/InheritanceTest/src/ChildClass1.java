public class ChildClass1 extends ParentClass1 {
    int v2;

    public void method2() {
        System.out.println("자식클래스의 변수 : " + v2);
    }

    public void method3() {
        v1 = 1000;
        method1();
    }
}
