/**
 * Name : Son, Junhee
 * Phone :
 * This project : if문 연습
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class If_Test2 {
    public static void main(String[] args) {
        System.out.print("\n짝수인지 홀수인지 확인할 숫자 입력: ");
        try {
        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader x = new BufferedReader(a);
        String str = x.readLine();
        int num = Integer.parseInt(str);

        if ( num%2 != 1) {
            System.out.print(num + "는(은) 짝수입니다\n");
        } else {
            System.out.print(num + "는(은) 홀수입니다\n");
        }
        }catch(Exception e) { }
    }
}
