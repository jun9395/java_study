import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 가위 1 바위 2 보 3
            String[] rsp = br.readLine().split(" ");

            int a = Integer.parseInt(rsp[0]), b = Integer.parseInt(rsp[1]);

            if (a == 1) {
                if (b > 2)
                    bw.write('A');
                else
                    bw.write('B');
            } else if (a == 2) {
                if (a > b)
                    bw.write('A');
                else
                    bw.write('B');
            } else {
                if (b < 2)
                    bw.write('B');
                else
                    bw.write('A');
            }
//            if (Integer.parseInt(rsp[0]) > Integer.parseInt(rsp[1]))
//                bw.write('A');
//            else
//                bw.write('B');
            bw.close();
        } catch (Exception e) {}
    }
}
