import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());

            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int t = 1; t <= T; t++) {
                String[] arr = br.readLine().trim().split("");
                for (String key : arr) {
                    if (hashMap.get(key) == null) hashMap.put(key, 1);
                    else {
                        int value = hashMap.get(key);
                        hashMap.put(key, value + 1);
                    }
                }

                String answer = "";
                for (String key : hashMap.keySet()) {
                    if (hashMap.get(key) % 2 == 1) answer += key;
                }

                if (answer.equals("")) answer = "Good";

                hashMap.clear();

                bw.write("#" + t + " " + answer + "\n");
                bw.flush();
            }

            bw.close();
            br.close();
        } catch (Exception e) {}
    }
}
