import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TwoByteStream1 {
    public static void main(String[] args) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(System.out);    // 콘솔에 출력
                // 기본스트림인 System.out이 있다
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("안녕하세요");
            pw.println("반갑습니다");
            pw.close();
            bw.close();
            osw.close();
        } catch (Exception e) {}
    }
}
