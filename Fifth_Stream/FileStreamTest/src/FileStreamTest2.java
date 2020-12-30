import java.io.FileInputStream;
import java.io.IOException;

public class FileStreamTest2 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(".\\test.txt");
            byte[] buf = new byte[fis.available()];
            int called = fis.read(buf);
            fis.close();

            String str = new String(buf);
            System.out.println(str);
            System.out.println("fis.read(buf)의 반환값은? " + called);
        } catch (IOException e) { System.out.println("파일이 없습니다"); }
    }
}
