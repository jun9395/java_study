import java.util.StringTokenizer;

public class TokenizerTest {
    public static void main(String[] args) {
        String str = "동해물과 백두산이-마르고 닳도록";

        StringTokenizer st = new StringTokenizer(str);

        while (st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }
        System.out.println();

        st = new StringTokenizer(str);

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken("-"));
        }
        System.out.println();

        str = "동해^물과 백두_산이 마르-고 닳^도록";

        st = new StringTokenizer(str, "^"); // 밑에서 nextToken 때 구분자 넣어서 같이 구분 가능
        while (st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }
        System.out.println();

        st = new StringTokenizer(str, "^_-");   // 이렇게 한번에 구분자를 넣어둘 수 있음
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
