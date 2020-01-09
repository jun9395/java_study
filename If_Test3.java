import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Name : Son, Junhee
 * Phone :
 * This project :
 */
public class If_Test3 {
    public static void main(String[] args) {
        System.out.print("양의 정수를 입력하세요: ");
        try{
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            String str = br.readLine();
            int num = Integer.parseInt(str);

            if (num%3 == 0) {
                System.out.print(num + "은(는) 3의 배수입니다\n");
            } else {
                System.out.print(num + "은(는) 3의 배수가 아닙니다\n");
            }
        } catch(Exception e) {}
    }
}
