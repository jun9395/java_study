public class Method1 {
    public void method1() {
        System.out.println("메서드 1번입니다");
    }

    public void method2() {
        System.out.println("메서드 2번입니다");
    }

    public void add1(int a, int b) {
        int result = a + b;
        System.out.println(result);
    }

    public int resultAdd(int a, int b) {
        int result = a + b;

        return result;
    }

    public void method1(int a) {
        System.out.println(a + "를 받았습니다. 메소드 오버로딩이 적용됐습니다");
    }
}
