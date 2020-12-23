public class StaticTest {
    // java 클래스이름 으로 실행하는데,
    // main을 객체 생성 없이 사용하므로 static을 붙여주는 것이다
    int a;
    static int b;

    public static void main(String[] args) {
//        a = 100;    // a는 nonstatic이라 접근할 수 없다
        b = 200;
        System.out.println(b);

        // 타 Class에서 static으로 선언된 경우에도 객체 생성이 필요 없다
        StaticClass1.a = 300;
        StaticClass1.method1();

        StaticClass1 c1 = new StaticClass1();
        StaticClass1 c2 = new StaticClass1();

        c1.a = 1000;
        System.out.println(c2.a);   // c1와 c2가 static이 붙은 공통 변수를 참조하므로
    }
}
