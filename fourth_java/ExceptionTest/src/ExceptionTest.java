import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        TestClass t = new TestClass();
        int result = t.method(10, 0);
        System.out.println(result);
    }
}


class TestClass {
    public int method(int a, int b) {
        int result = 0;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("0을 입력했습니다");    // b가 0이면 오류가 발생하므로 이 부분을 실행함
        } finally {
            System.out.println("이 부분은 무조건 실행됩니다");
        }
        return result;
    }
}