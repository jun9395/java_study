import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());

            for (int t = 1; t <= T; t++) {
                int n = Integer.parseInt(br.readLine().trim());
                bw.write("#" + t + "\n");
                bw.write("1\n");

                Integer[] pre_arr = new Integer[]{1};

                for (int i = 2; i <= n; i++) {
                    Integer[] arr = new Integer[i];
                    Arrays.fill(arr, 0);
                    arr[0] = arr[arr.length - 1] = 1;

                    for (int j = 1; j < i - 1; j++) {
                        arr[j] = pre_arr[j] + pre_arr[j - 1];
                    }

                    pre_arr = arr.clone();

                    String[] str = Arrays.toString(arr).split("[\\[\\]]")[1].split(", ");
                    bw.write(String.join(" ", str) + "\n");
                }
            }

            br.close();
            bw.close();
        } catch (Exception e) {}
    }
}
