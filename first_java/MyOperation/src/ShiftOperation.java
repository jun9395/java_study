public class ShiftOperation {
    public static void main(String [] args) {
        int four = 4;

        System.out.println("eight? " + (four<<1));  // 시프트 연산은 사칙연산보다 후위순위다
        System.out.println("two? " + (four>>1));

        int seven = 7;

        System.out.println("fourteen? " + (seven<<1));
        System.out.println("three? " + (seven>>1));

        int minussix = -6;

        System.out.println("minus twelve? " + (minussix<<1));
        System.out.println("minus three? " + (minussix>>1));
        System.out.println("minus three? " + (minussix>>>1));
    }
}
