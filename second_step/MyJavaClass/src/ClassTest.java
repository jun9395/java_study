public class ClassTest {
    public static void main(String[] args) {
        Class1 c1 = new Class1();   // 객체 생성
        c1.va = 100;    // Class1 내의 멤버변수에 접근
        System.out.println(c1.va);

        // 함수를 통해 멤버메소드에 접근
        c1.setVa(1000);
        System.out.println(c1.getVa());


        Class1 c2 = new Class1();
        c2.va = 200;
        System.out.println(c2.va);

        c2.setVa(2000);
        System.out.println(c2.va);
    }
}
