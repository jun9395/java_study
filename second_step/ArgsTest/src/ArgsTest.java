// javac ArgsTest.java
// java ArgsTest 10 20 30 -> 10\n 20\n 30\n 출력됨
// java ArgsTest Hello World -> Hello\n World\n 출력됨
// java ArgsTest "Hello World" -> Hello World\n 출력됨

public class ArgsTest {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
