import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


// 1216 정리
public class StandardInput {
    public static void main(String[] args) {
        try {
            // 1. 기본적인 키보드 입력값 하나를 받기
            // 그런데 요새는 엔터를 쳐줘야 넘어간다
            // 그 엔터는 원래는 CRLR로 2개였으나, 이제는 1개의 입력값을 갖는다
//            int a1 = System.in.read();
//            System.out.println("하나의 입력값 " + a1);
//            System.in.read();   // 엔터를 버리는 부분
//            char a2 = (char)System.in.read();   // 기본적으로 int로 입력받는다
//            System.out.println("그 다음 입력값 " + a2);


            // 2. BufferedReader InputStreamReader로 str 형태로 받기
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // readLine()은 str으로 입력받는다
//            System.out.println(str);
//
//            System.out.printf("%f\n", Float.parseFloat(str));   // str의 값을 float로 변환한다(단, 형태변환이 가능해야 함)


            // 2.1 문자열을 split 하기
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String[] strarr = br.readLine().split(":"); // :로 구분하여 split 한다
//            System.out.println(strarr[0] + ":" + strarr[1]);
            String[] strarr = new BufferedReader(new InputStreamReader(System.in)).readLine().split("\\."); // .은 기본적으로 . 인자이므로 이렇게 써야 한다

            System.out.printf("%d.%02d.%02d\n", Integer.parseInt(strarr[0]), Integer.parseInt(strarr[1]), Integer.parseInt(strarr[2]));


            // 3. Scanner로 str 형태로 받기 (int, double로 받기 쉬움)

//            Scanner input = new Scanner(System.in);
////            String sc_str = input.next();
//            int sc_int = input.nextInt();
//            int sc_int2 = input.nextInt();
////            double sc_double = input.nextDouble();
//
//            System.out.printf("%d %d\n", sc_int, sc_int2);
        } catch (Exception e) {}
    }
}



//public class StandardInput {
//    public static void main(String [] args) {
////        try {
////            int a1 = System.in.read();
////            System.out.println("방금 누른 " + a1);
////            int a2 = System.in.read();
////            System.out.println("덧붙여서 눌러준 " + a2);
////            int whatisthis = System.in.read();  // 이제 엔터는 1개의 입력값만 갖는다
////            System.out.println(whatisthis);
////            int a3 = System.in.read();
////            System.out.println("하나를 더 입력해준 " + a3);
////        } catch (Exception e) {}
//
//        try {
////            InputStreamReader ir = new InputStreamReader(System.in);
////            BufferedReader br = new BufferedReader(ir);
////            String str = br.readLine();
////
////            System.out.println(str);
////            float f1;
////
////            f1 = Float.parseFloat(str);
////
////            char c1 = (char)System.in.read();
////
////            System.out.println("c1 = " + c1);
//
//
//            // 이렇게 하면 숫자 2개를 동시에 입력받을 수 있다
//            Scanner input = new Scanner(System.in);
//
////            double num1 = input.nextDouble();
////            double num2 = input.nextDouble();
////
////            System.out.printf("%f %f\n", num1, num2);
//
//
//            int num1 = input.nextInt();
//            int num2 = input.nextInt();
//
//            System.out.printf("%d %d\n", num1, num2);
//
//
//
//
//        } catch (Exception e) {}
//    }
//}
