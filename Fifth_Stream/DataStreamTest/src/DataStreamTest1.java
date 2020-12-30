import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest1 {
    public static void main(String[] args) {
        try {
            String fileName = ".\\test.txt";
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF("안녕하세요");
            dos.writeInt(10);
            dos.writeInt(20);

            dos.close();
            fos.close();
            System.out.println("출력완료");
        } catch (IOException e) {}
    }
}
