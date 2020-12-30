import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TwoByteStream2 {
    public static void main(String[] args) {
        try {
            File file = new File(".\\test.txt");
            FileWriter fw = new FileWriter(file);   // 파일에 출력
                // file에 작성한다는 기본스트림이 없으므로 file을 만들어준다
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("안녕하세요");
            pw.close();   // 이것만 닫아도 배출 된다
//            bw.close();   // 이것만 닫아도 배출 된다
//            fw.close();   // 이것만 닫으면 배출이 안 된다
        } catch (Exception e) {}
    }
}
