public class PolyTest {
    public static void main(String[] args) {
        SubClass sc1 = new SubClass();

        sc1.superV1 = 100;
        sc1.superMethod();

        System.out.println();

        SuperClass super1 = new SubClass();
        super1.superV1 = 200;
        super1.superMethod();   // 오버라이딩 됐으므로 자식의 메서드가 호출됨

        System.out.println();



        sc1.subV1 = 300;
        sc1.subMethod();
        // 자식 클래스 타입을 부모 클래스로 생성했기 때문에 접근범위가 제한된다
//        super1.subV1 = 400;
//        super1.subMethod();

        // 위의 superMethod들은 모두 오버라이딩 됐다
        sc1.superMethod();

        System.out.println();

        // 자식에 의해 오버라이딩된 부모의 메서드를 호출하면,
        // 오버라이딩한 자식의 메서드를 호출한다. 위에서도 확인 가능
        super1.superMethod();
    }
}
