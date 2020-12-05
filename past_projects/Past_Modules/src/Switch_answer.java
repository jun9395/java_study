import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Name : Son, Junhee
 * Phone :
 * This project : switch문 연습문제 답
 */
public class Switch_answer {
    public static void main(String[] args) {
        try{
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            System.out.print("첫 번째 숫자 입력: ");
            String str1 = br.readLine();
            int num1 = Integer.parseInt(str1);
            System.out.print("두 번째 숫자 입력: ");
            String str2 = br.readLine();
            int num2 = Integer.parseInt(str2);
            System.out.print("수행할 사칙연산 입력: ");
            char ch = (char)System.in.read();

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
                    System.out.printf("%d / %d = %.2f\n", num1, num2, (float)num1/num2);
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }catch(Exception e) {}
    }
}
