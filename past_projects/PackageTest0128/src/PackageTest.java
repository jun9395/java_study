//import test.pack1.PClass1;
//import test.pack1.PClass2;
import test.pack1.*;

/**
 * Name : Son, Junhee
 * Phone :
 * This project : 패키지에 대해서 알아보기
 */
public class PackageTest {
    public static void main(String[] args) {
        PClass1 p1c1 = new PClass1();
        PClass2 p1c2 = new PClass2();

        p1c1.method1();
        p1c2.method2();

        test.pack2.P2Class1 p2c1 = new test.pack2.P2Class1();
        test.pack2.P2Class2 p2c2 = new test.pack2.P2Class2();

        p2c1.method1();
        p2c2.method2();
    }
}
