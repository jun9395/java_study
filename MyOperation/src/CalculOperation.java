public class CalculOperation {
    public static void main(String [] args) {
        int a1 = 108;
        int a2 = 216;
        int a3 = 5;

        System.out.println("a1 + a2 = " + a1 + a2);     // 문자열과 숫자의 연산이 발생하면 숫자를 문자열로 바꾸어서 연결한다
        System.out.println(a1 + a2 + "a1 + a2 = ");     // 어디에 있든 동일하다
        System.out.println("a1 + a2 = " + (a1 + a2));
//        System.out.println("a1 + a2 = " + a1 - a2);   // 그러므로 이런 연산은 불가능하다
        System.out.println("a1 - a2 = " + (a1 - a2));
        System.out.println("a1 * a2 = " + a1 * a2);     // 곱하기 연산이 더하기보다 우선순위를 가지므로 가능하다
        System.out.println("a1 * a2 = " + (a1 * a2));
        System.out.println("a1 / a2 = " + a1 / a2);     // 마찬가지 이유다
        System.out.println("a1 / a2 = " + (a1 / a2));   // 또한 int형들의 나눗셈이므로 자동으로 버림을 취한다
        System.out.println("a1 % a3 = " + a1 % a3);
    }
}
