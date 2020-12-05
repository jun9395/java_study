import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandardInput {
    public static void main(String [] args) {
//        try {
//            int a1 = System.in.read();
//            System.out.println("방금 누른 " + a1);
//            int a2 = System.in.read();
//            System.out.println("덧붙여서 눌러준 " + a2);
//            int whatisthis = System.in.read();  // 이제 엔터는 1개의 입력값만 갖는다
//            System.out.println(whatisthis);
//            int a3 = System.in.read();
//            System.out.println("하나를 더 입력해준 " + a3);
//        } catch (Exception e) {}

        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            String str = br.readLine();

            System.out.println(str);

            char c1 = (char)System.in.read();

            System.out.println("c1 = " + c1);
        } catch (Exception e) {}
    }
}
