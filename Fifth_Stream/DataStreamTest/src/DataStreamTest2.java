import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataStreamTest2 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(".\\test.txt");
            DataInputStream dis = new DataInputStream(fis);

            String str = dis.readUTF();
            int a = dis.readInt();
            int b = dis.readInt();
            dis.close();
            fis.close();

            System.out.println(str);
            System.out.println(a);
            System.out.println(b);
        } catch (IOException e) {}
    }
}
