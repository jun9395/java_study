import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

            int sum = 0;
            for (int i = 1; i <= n; i++)
                sum += i;
            bw.write(sum + "");
            bw.close();
        } catch (Exception e) {}
    }
}
