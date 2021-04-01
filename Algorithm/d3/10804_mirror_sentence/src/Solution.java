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
                bw.write("#" + t + " ");
                String[] arr = br.readLine().trim().split("");

                for (int i = arr.length - 1; i > -1; i--) {
                    switch (arr[i]) {
                        case "b":
                            bw.write("d");
                            break;
                        case "d":
                            bw.write("b");
                            break;
                        case "p":
                            bw.write("q");
                            break;
                        case "q":
                            bw.write("p");
                            break;
                    }
                }
                bw.write("\n");
                bw.flush();
            }

            bw.close();
            br.close();
        } catch (Exception e) {}
    }
}
