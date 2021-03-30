import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] arr = br.readLine().split(" ");
            int answer = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]) + 1;

            bw.write("" + answer);
            bw.close();
        } catch (Exception e) {}
    }
}
