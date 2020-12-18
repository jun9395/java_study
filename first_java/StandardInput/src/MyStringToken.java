import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyStringToken {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer str = new StringTokenizer(br.readLine());
            String sentence;
            while (str.hasMoreTokens()) {   // Token이 남아있는 동안에
                sentence = str.nextToken();
                System.out.println(sentence);
            }
        } catch (Exception e) {}
    }
}
