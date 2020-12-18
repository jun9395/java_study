import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MyBufferedWriter {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < num; i++) {
                bw.write(Integer.toString(i));
                bw.flush();
            }
        } catch (Exception e) {}
    }
}
