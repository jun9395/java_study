import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main (String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int value = 1;
            bw.write(Integer.toString(value) + ' ');

            for (int i = 1; i <= n; i++) {
                value *= 2;
                bw.write(Integer.toString(value) + ' ');
            }

            bw.close();
        } catch (Exception e ) {}
    }
}
