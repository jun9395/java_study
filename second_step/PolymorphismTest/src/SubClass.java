public class SubClass extends SuperClass {
    int subV1;

    public SubClass() {
        super(100); // 부모 클래스를 자동으로 부름
        System.out.println("자식 클래스의 생성자");
    }

    public void subMethod() {
        System.out.println("SubClass의 메서드 - subV1 : " + subV1);
    }

    public void superMethod() {
        System.out.println("오버라이딩한 메서드");
        super.superMethod();
    }
}
