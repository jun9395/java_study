import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Name : Son, Junhee
 * Phone :
 * This project : switch문 연습문제
 */
public class Switch_question {
    public static void main(String[] args) {
        System.out.print("수행하려는 간단한 연산을 입력: ");
        try{
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            int num1 = br.read() - '0'; // 이러면 두 자리 수가 입력이 안 된다.
            int ch = br.read();
            int num2 = br.read() - '0';


            switch(ch) {
                case '+':
                    System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);
                    break;
                case '-':
                    System.out.printf("%d - %d = %d\n", num1, num2, num1-num2);
                    break;
                case '*':
                    System.out.printf("%d * %d - %d\n", num1, num2, num1*num2);
                    break;
                case '/':
                    System.out.printf("%d / %d = %d\n", num1, num2, (float)num1/num2);
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }catch(Exception e) {}
    }
}
