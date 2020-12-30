import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileStreamTest1 {
    public static void main(String[] args) {
        try {
            String fileName = ".\\test.txt";
            FileOutputStream fos = new FileOutputStream(fileName, true);
            byte[] data = "안녕하세요".getBytes(StandardCharsets.UTF_8);
            fos.write(data);
            fos.flush();
            fos.close();
            System.out.println("파일 작성 성공");
        } catch (IOException e) {}
    }
}
