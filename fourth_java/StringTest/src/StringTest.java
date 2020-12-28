import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "안녕하세요";  // 처음에 안녕하세요를 생성하면 메모리 할당됨

        // 문자열 기존 비교
        if (str1 == "안녕하세요") {  // 두 번째로 할당된 안녕하세요를 생성하고자 하면 이미 생성된 값을 참조함
            System.out.println("문자열이 같습니다");
        } else {
            System.out.println("문자열이 다릅니다");
        }

        String str2 = new String("안녕하세요");
        if (str1 == str2) {
            System.out.println("문자열이 같습니다");
        } else {
            System.out.println("문자열이 다릅니다");
        }

        String str3 = "안녕하세요";
        if (str1 == str3) {
            System.out.println("문자열이 같습니다");
        } else {
            System.out.println("문자열이 다릅니다");
        }


        // 실제 내용값을 비교
        if (str1.equals(str2)) {
            System.out.println("두 문자열이 같습니다");
        } else {
            System.out.println("두 문자열이 다릅니다");
        }



        String eng1 = "abCDef";
        String eng2 = "ABcdEF";

        if (eng1.equals(eng2)) {
            System.out.println("두 문자열이 같습니다");
        } else {
            System.out.println("두 문자열이 다릅니다");
        }

        if (eng1.equalsIgnoreCase(eng2)) {
            System.out.println("두 문자열이 같습니다");
        } else {
            System.out.println("두 문자열이 다릅니다");
        }

        String upperStr = eng1.toUpperCase();
        String lowerStr = eng2.toLowerCase(Locale.ROOT);
        System.out.println(upperStr + ", " + lowerStr);


        if (lowerStr.startsWith("abc")) {
            System.out.println("abc로 시작합니다");
        } else {
            System.out.println("abc로 시작하지 않습니다");
        }

        if (upperStr.endsWith("ABC")) {
            System.out.println("ABC로 끝납니다");
        } else {
            System.out.println("ABC로 안 끝납니다");
        }

        System.out.println(lowerStr.indexOf("cd")); // 3번째에 존해하므로 index인 2
        System.out.println(lowerStr.indexOf("cc")); // 존재하지 않으므로 -1

        byte[] br = lowerStr.getBytes();    // 문자열을 Byte로 바꾸기
        byte[] br2 = str1.getBytes(StandardCharsets.UTF_8);

        System.out.println();
        for (byte b : br) {
            System.out.println(b + " ");
        }

        System.out.println();
        for (byte b : br2)  // 한글도 되긴 되는데 쓰는건 생각해보자
            System.out.println(b + " ");
        System.out.println();


        // 바이트로 된 문자열을 String으로 바꾸기
        String str100 = new String(br);
        System.out.println(str100); // 외부에서 가져온 Byte로 된 문자열을 읽어들일 때


        // 문자열의 일부 가져오기
        String str4 = str100.substring(1, 3);
        System.out.println(str4);
    }
}
