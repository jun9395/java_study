public class MethodTest {
    public static void main(String[] args) {
        Method1 m1 = new Method1();

        m1.method1();

        m1.add1(100, 200);

        int result = m1.resultAdd(250, 750);
        System.out.println("리턴받은 값: " + result);

        m1.method1(15);
    }
}
