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
            for (int t = 0; t < T; t++) {
                String[] arr = br.readLine().split(" ");
                int a = Integer.parseInt(arr[0]), b = Integer.parseInt(arr[1]);
                bw.write("#" + (t + 1) + " " + (a / b) + " " + (a % b) + "\n");
            }
            bw.close();
        } catch (Exception e) {}
    }
}
