public class WrapperClass {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);


        // Boxing
        // 일반 기본 자료형 값을 Wrapper Class로 포장하여 객체화 하는 작업
        Integer intClass = new Integer(100);
        Float floatClass = new Float(12.24F);

        // UnBoxing
        // Class에 담겨진 값을 갖고 나오기
        int intValue = intClass.intValue(); // 각각 맞는 자료형에 부여해서 갖고 나오기
        float floatValue = floatClass.floatValue();
        System.out.println(intValue);
        System.out.println(floatValue);


        // Java 1.5부터 지원
        Integer intClass2 = 200;
        int intValue2 = intClass2;
        System.out.println(intClass2);


        // Parsing
        int parsingValue = Integer.parseInt("12345");
        float parsingValue2 = Float.parseFloat("12.34");
        System.out.println("12345" + "12.34");
        System.out.println(parsingValue + parsingValue2);

//        Integer.parseInt("woijow");
    }
}
