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
                String[] arr = br.readLine().trim().split("");
                int flag = 1;

                for (int i = 0; i < arr.length / 2; i++) {
                    if (!arr[i].equals(arr[arr.length - 1 - i])) {
                        flag = 0;
                        break;
                    }
                }
                bw.write("#" + t + " " + flag + "\n");
            }

            bw.close();
        } catch (Exception e) {}
    }
}
