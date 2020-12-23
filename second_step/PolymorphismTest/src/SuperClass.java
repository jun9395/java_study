public class SuperClass {
    int superV1;

    public SuperClass() {
        System.out.println("부모클래스의 생성자");
    }

    public SuperClass(int a) {
        System.out.println("부모클래스의 생성자2: " + a);
    }

    public void superMethod() {
        System.out.println("SuperClass의 메서드 - superV1 : " + superV1);
    }
}
