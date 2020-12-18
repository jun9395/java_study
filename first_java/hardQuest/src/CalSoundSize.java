import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class CalSoundSize {
    public static void main(String[] args) {
        try {
            String[] hbcs = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            long bit = 1;
            // 더 향상된 for문 형태
            for (String hbc : hbcs) bit *= Integer.parseInt(hbc);
//            for (int i = 0; i < hbcs.length; i++)
//                bit *= Integer.parseInt(hbcs[i]);
            bit /= 8;
            bw.write(String.format("%.1f MB\n", (double)bit / 1024 / 1024));
            bw.close();
        } catch (Exception e) {}
    }
}