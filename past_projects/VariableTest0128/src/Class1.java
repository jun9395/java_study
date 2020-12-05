/**
 * Name : Son, Junhee
 * Phone :
 * This project :
 */
public class Class1 {
    int a;

    public void method1() {
        int a = 20;
        System.out.println("메소드의 지역 변수 a: " + a);
        System.out.println("클래스의 멤버 변수 a: " + this.a); // 이 클래스의 멤버변수에 접근
    }

    public void namethod() {
        int a = 30;
        System.out.println("메소드 2의 지역 변수 a: " + a);
    }
}
