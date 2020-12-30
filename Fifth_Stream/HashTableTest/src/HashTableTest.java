import java.util.Hashtable;

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();

        // 데이터 넣기
        ht.put("str", "안녕하세요");
        ht.put("int", 100);

        // 데이터 불러오기
        String str = (String)ht.get("str");
        int data = (int)ht.get("int");

        System.out.println(str);
        System.out.println(data);


        // Generic 타입   // Key값 타입, value값 타입
        Hashtable<String, String> ht2 = new Hashtable<String, String>();
        ht2.put("str", "안녕하세요");
        ht2.put("int", "100");
        System.out.println(ht2.get("str"));
        System.out.println(ht2.get("int"));
    }
}
