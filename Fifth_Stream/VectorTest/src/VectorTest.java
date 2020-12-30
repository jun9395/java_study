import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector v1 = new Vector();

        v1.addElement("안녕하세요");
        v1.addElement("반갑습니다");
        v1.addElement("ㅡㅅㅡ;");

        System.out.println("개수: " + v1.size());

        for (int i = 0; i < v1.size(); i++) {
//            String str = v1.elementAt(i);   // Object 타입으로 추출하므로 오류발생
            String str = (String)v1.elementAt(i);
            System.out.println(str);
        }


        // Wrapper 클래스
        // 일반적인 Primitive 타입을 넣을 수 없다
        Vector v2 = new Vector();
        v2.addElement(10);  // 예전에는 넣을 수 없었는데, 지금은 들어간다
        v2.addElement(new Integer(20)); // 지금은 불필요한 박싱이다
        v2.addElement(30);
//        v2.addElement(3.14);  // 들어가긴 들어간다. 이 밑의 for문에서 int로 캐스팅 하므로 출력은 안 됨

        for (int i = 0; i < v2.size(); i++)
            System.out.println((int)v2.elementAt(i));


        Vector<String> v3 = new Vector<String>();
        v3.addElement("ㅡ.ㅡ");
        v3.addElement("T_T");
        v3.addElement("OTL");

        for (int i = 0; i < v3.size(); i++)
            System.out.println(v3.elementAt(i));

        for (String str : v3)
            System.out.println(str);
    }
}
