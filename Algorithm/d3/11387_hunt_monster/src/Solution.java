import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());

            for (int t = 1; t <= T; t++) {
                String[] arr = br.readLine().trim().split(" ");
                int D = Integer.parseInt(arr[0]);
                int L = Integer.parseInt(arr[1]);
                int N = Integer.parseInt(arr[2]);

                bw.write("#" + t + " " + (D * N + D * L / 100 * (N * (N + 1) / 2)) + "\n");
            }

            bw.close();
            br.close();
        } catch (Exception e) {}
    }
}
