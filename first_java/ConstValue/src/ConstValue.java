public class ConstValue {
    public static void main(String [] args) {
        System.out.printf("정수: %d\n", 100);
        System.out.printf("%d %d\n", 100, 200);

        System.out.printf("큰 정수: %d\n", 2147483648L);   // 매우 큰 숫자를 64bit로 처리하기 위해 L을 붙여준다

        System.out.printf("문자: %c\n", 'a');
        System.out.printf("아스키코드: %c\n", 65);

        System.out.printf("실수: %.2f\n", 3.14159205);
    }
}
