import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = 5;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++)
                    if (x == y)
                        bw.write("#");
                    else
                        bw.write("+");
                bw.write("\n");
            }
            bw.close();
        } catch (Exception e) {}
    }
}
