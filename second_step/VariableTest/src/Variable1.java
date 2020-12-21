public class Variable1 {
    int member = 10;

    public void method1() {
        int member = 1;
        System.out.println("메소드의 지역변수 : " + member);
        // 메서드의 지역변수가 동일한 이름으로 존재하지 않는다면 위의 코드로도 아래의 코드의 결과를 낼 수 있다
        System.out.println("클래스의 멤버 변수 : " + this.member);
    }

    public void method2() {
        int member = 7;
        System.out.println("메소드의 지역변수2 : " + member);
    }
}
