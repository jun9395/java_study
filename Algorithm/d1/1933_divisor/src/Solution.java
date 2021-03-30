import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int root_n = (int)Math.sqrt(n) + 1;

            String[] arr = new String[n + 1];
//            List<String> arr = new ArrayList<String>();
//            arr.add
            Arrays.fill(arr, "");

            for (int i = 1; i < root_n; i++) {
                if (n % i == 0) {
                    arr[i] = Integer.toString(i) + " ";
                    arr[n + 1 - i] = Integer.toString(n / i) + " ";
                }
            }

            bw.write(String.join("", arr));

            bw.close();

        } catch (Exception e) {}
    }
}
