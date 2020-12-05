public class BitOperation {
    public static void main(String [] args) {
        System.out.printf("%32s -> %d\n", Integer.toBinaryString(100), 100);
        System.out.printf("%32s -> %d\n", Integer.toBinaryString(200), 200);
        System.out.println();
        System.out.printf("%32s -> %d\n", Integer.toBinaryString(100 & 200), 100 & 200);
        System.out.printf("%32s -> %d\n", Integer.toBinaryString(100 | 200), 100 | 200);
        System.out.printf("%32s -> %d\n", Integer.toBinaryString(100 ^ 200), 100 ^ 200);

        System.out.println();

        System.out.printf("%d\n", 27 & 49);
        System.out.println("이 경우에도 작동한다 : " + (27 & 49));
    }
}
