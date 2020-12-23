public class Encapsulation {
    public static void main(String[] args) {
        Class1 c = new Class1();

        c.defaultValue = 200;
        System.out.println(c.defaultValue);

//        c.privateValue = 300;

        c.setPrivateValue(300);
        System.out.println(c.getPrivateValue());
    }
}
