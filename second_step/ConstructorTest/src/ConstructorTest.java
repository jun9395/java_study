public class ConstructorTest {
    public static void main(String[] args) {
        new ConstructorTest();  // 밑의 코드를 주석처리해도 기본 생성자가 추가되므로 오류가 나지 않음
//        new ConstructorTest(10);
//        new ConstructorTest(10, 20);
    }

//    // 매개 변수가 없는 생성자
//    public ConstructorTest() {
//        System.out.println("Default 생성자");
//    }
//
//    // 매개 변수가 있는 생성자
//    public ConstructorTest(int a) {
//        System.out.println("넘겨받은 정수 값: " + a);
//    }
//
//    public ConstructorTest(int a, int b) {
//        System.out.println("두 수의 합: " + (a + b));
//    }
}
