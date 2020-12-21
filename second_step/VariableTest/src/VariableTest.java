public class VariableTest {
    public static void main(String[] args) {
        Variable1 v1 = new Variable1();

        v1.member = 100;
        System.out.println(v1.member);

        v1.method1();
        v1.method2();
    }
}
