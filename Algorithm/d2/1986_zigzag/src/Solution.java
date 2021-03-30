import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                int n = Integer.parseInt(br.readLine());
                int sumV = 0;

                for (int i = 1; i <= n; i++) {
                    sumV = i % 2 == 1 ? sumV + i : sumV - i;
//                    if (i % 2 == 1)
//                        sumV += i;
//                    else
//                        sumV -= i;
                }

                bw.write("#" + t + " " + sumV + "\n");
            }
            bw.close();
        } catch (Exception e) {}
    }
}
