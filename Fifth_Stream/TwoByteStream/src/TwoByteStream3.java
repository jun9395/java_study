import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoByteStream3 {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("키보드로 입력해주세요: ");
            String str = br.readLine();
            System.out.println(str);
            br.close();
            isr.close();
        } catch (Exception e) {}
    }
}
