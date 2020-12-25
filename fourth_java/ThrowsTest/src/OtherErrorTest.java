import java.io.IOException;

public class OtherErrorTest {
    public static void main(String[] args) {
        TestClass3 t = new TestClass3();
        int result = 0;

        try {
            result = t.method(10, 2);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("예외발생");
        } catch (IOException e) {

        } catch (MyException e) {
            System.out.println("사용자 정의 예외 발생");
            System.out.println(e.toString());   // 어떤 예외인지 출력해주는 코드
            e.printStackTrace();    // 예외가 어디서 발생했는지 추적 출력
        }
        System.out.println(result);
    }
}


class TestClass3 {
    public int method(int a, int b) throws ArithmeticException, IOException, MyException {
        int result = 0;
        result = a / b;
//        System.in.read();
        if (b <= 10) {
            throw new MyException();
        }
        return result;
    }
}


class MyException extends Exception {
    public String getMessage() {
        return "10보다 큰 값을 넣어주세요";
    }
}