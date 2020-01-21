/**
 * Name : Son, Junhee
 * Phone :
 * This project :
 */
public class ClassTest {
    public static void main(String[] args) {
        Class1 c1 = new Class1(); // 새로운 객체를 생성하여 Class1형 c1변수에 메모리값 할당
        c1.va = 100; // 참조변수.va를 통해 할당된 Class1의 va라는 변수에 접근
        System.out.println(c1.va);
        // . 연산자를 통해 Class1에 영향을 끼치는 게 아니라 객체를 하나 생성하여
        // 해당 개체에 접근한다
        c1.setVa(1000); // Class1 내부에 있는 setVa를 통해 va에 접근
        System.out.println(c1.getVa());

        Class1 c2 = new Class1();
        c2.setVa(1500);
        System.out.println(c2.getVa());
    }
}
