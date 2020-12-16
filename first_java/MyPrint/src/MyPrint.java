public class MyPrint {
    public static void main(String [] args) {
        System.out.println("안녕하세요");    // 한 줄 내려준다
        System.out.print("반갑습니다");      // 한 줄 내리지 않는다
        
        System.out.println(100);    // 숫자 출력도 당연히 가능

        System.out.println("특수문자는 \"이렇게\" 출력한다");

        System.out.println("\"!@#$%^&*()\"");


        System.out.println("\u250C\u252C\u2510");
        System.out.println("\u251C\u253C\u2524");
        System.out.println("\u2514\u2534\u2518");
    }
}
