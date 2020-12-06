public class LogicOperation {
    public static void main(String [] args) {
        int a = 6;
        System.out.println((10 > a) && (a++ > 1));
        System.out.println("a : " + a);
        System.out.println((10 < a) && (a++ > 1));
        System.out.println("a : " + a);
        System.out.println((10 > a) & (a++ > 1));
        System.out.println("a : " + a);
        System.out.println((10 < 7) & (a++ > 1));
        System.out.println("a : " + a);
        System.out.println("이거랑은 조금 다르다" + (10 & a));
        a = 6;
        System.out.println((10 > a) || (a++ > 1));
        System.out.println("a : " + a);
        System.out.println((10 < a) || (a++ > 1));
        System.out.println("a : " + a);
        System.out.println((10 < 7) || (a++ > 1));
        System.out.println("a : " + a);
        System.out.println((10 < 7) | (a++ > 1));
        System.out.println("a : " + a);
    }
}
