import java.io.IOException;

public class ThrowsTest {
    public static void main(String[] args) {
        TestClass t = new TestClass();
        int result = 0;

        try {
            result = t.method(10, 2);
            System.out.println(result);
        } catch (ArithmeticException e) {

        } catch (IOException e) {

        }
        System.out.println(result);
    }
}


class TestClass {
    public int method(int a, int b) throws ArithmeticException, IOException {
        int result = 0;
        result = a / b;
        System.in.read();
        return result;
    }
}