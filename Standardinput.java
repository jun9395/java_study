import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Standardinput {
    public static void main(String[] args) {
        try {
            /*
            System.out.print("Enter keyboards: ");
            int a1 = System.in.read();
            System.out.println("a1 : " + a1);
            System.in.read(); // 하나만 입력해서 엔터를 누르면 CR 입력받음
            System.in.read(); // LF 입력받음
            int a2 = System.in.read();
            System.out.println("a2 : " + a2);
            */
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);

            System.out.print("Enter your sentence: ");
            String str = br.readLine();
            System.out.println(str);

            System.out.print("Enter c1: ");
            char c1 = (char)System.in.read();

            System.out.println("c1: " + c1);
        }catch(Exception e) { }
    }
}
