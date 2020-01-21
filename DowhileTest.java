import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Name : Son, Junhee
 * Phone :
 * This project : 사용자로부터 100 이하의 숫자를 계속 입력받아 출력하는 프로그램
 */
public class DowhileTest {
    public static void main(String[] args) {
        int i = 0;

        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            int num = 0;
            do{
                System.out.printf(++i + "번째 숫자 입력: ");
                String str = br.readLine();
                num = Integer.parseInt(str);
                System.out.println(i + "번째 숫자: " + num);
            } while (num <= 100);
            System.out.println("종료");
        } catch (Exception e) {};
    }
}
