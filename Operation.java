public class Operation {
    public static void main(String[] args) {
        int i1 = 100;

        System.out.printf("a1 : %32s\n", Integer.toBinaryString(i1));
        // i1의 값을 binary 형태의 문자열로
        System.out.println();
        System.out.printf("%32s %d\n", Integer.toBinaryString(100), 100);
        System.out.printf("%32s %d\n", Integer.toBinaryString(100>>1), 100>>1);
        System.out.printf("%32s %d\n", Integer.toBinaryString(100>>2), 100>>2);
        System.out.println();
        System.out.printf("%32s %d\n", Integer.toBinaryString(-100), -100);
        System.out.printf("%32s %d\n", Integer.toBinaryString(-100>>1), -100>>1);
        System.out.printf("%32s %d\n", Integer.toBinaryString(-100>>2), -100>>2);
        System.out.printf("%32s %d\n", Integer.toBinaryString(-100>>>2), -100>>>2);

        System.out.println();

        int i=1, j=2, k=3;
        System.out.println(j>i && k>i++);
        System.out.println(i);
        System.out.println(j<i && k>i++); // 좌항이 거짓이면 우항을 실행하지 않고 반환
        System.out.println(i);
        System.out.println(j>i & k<i++); // 우항의 참거짓에 관계없이 실행을 한번 한다
        System.out.println(i);
        System.out.println(j>i & k>i++); // 우항의 참거짓에 관계없이 실행을 한다
        System.out.println(i);

        System.out.println();
        System.out.println(200>100? 200:100);
    }
}
