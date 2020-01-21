/**
 * Name : Son, Junhee
 * Phone :
 * This project :
 */
public class MethodClass {
    public void method1() {
        System.out.println("메소드 1번입니다");
        method2(); // 같은 class 내부의 함수(메소드)는 자유롭게 사용 가능
    }
    public void method2() {
        System.out.println("메소드 2번입니다");
    }

    public void add(int a, int b) {
        int result = a + b;
        System.out.println("정수 연산: " + a + " + " + b + " = " + result);
    }

    public void add(int a, int b, int c) { // Overloading
        int result = a + b + c;
        System.out.println("정수 3개 연산: " + a + " + " + b + " + " + c + " = " + result);
    }

    public int resultAdd(int a, int b) {
        int result = a + b;

        return result;
    }
}
