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
                String[] arr = br.readLine().trim().split(" ");
                int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
                Arrays.sort(nums);
                int sumV = 0;
                for (int i = 1; i < nums.length - 1; i++)
                    sumV += nums[i];
//                int answer = Math.round((double)sumV / (nums.length - 2));
//                int answer = sumV / (nums.length - 2);
                double answer = (double)sumV / (nums.length - 2);
                bw.write("#" + t + " " + Math.round(answer) + "\n");
                bw.flush();
            }

            bw.close();
        } catch (Exception e) {}
    }
}
