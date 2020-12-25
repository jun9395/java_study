import java.io.IOException;

public class ThrowTest {
    public static void main(String[] args) {
        TestClass2 t = new TestClass2();
        int result = 0;

        try {
            result = t.method(10, 2);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("예외발생");
        } catch (IOException e) {

        }
        System.out.println(result);
    }
}


class TestClass2 {
    public int method(int a, int b) throws ArithmeticException, IOException {
        int result = 0;
        result = a / b;
//        System.in.read();
        if (b > 0) {
            throw new ArithmeticException();    // 이 코드를 실행하게 되면 예외를 발생시키고,
            // 코드를 종료한 뒤 같은 Exception으로 예외를 전달한다
        }
        return result;
    }
}
