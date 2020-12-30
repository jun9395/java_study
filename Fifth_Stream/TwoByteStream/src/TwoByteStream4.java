import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TwoByteStream4 {
    public static void main(String[] args) {
        try {
            File file = new File(".\\test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String str1 = br.readLine();
            String str2 = br.readLine();
            br.close();
            fr.close();
            System.out.println(str1);
            System.out.println(str2);
        } catch (Exception e) {}
    }
}
