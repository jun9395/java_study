import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoRowsInput {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        } catch (Exception e) {}
    }
}