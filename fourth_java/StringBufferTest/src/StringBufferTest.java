public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("안녕");
        StringBuffer sb2 = new StringBuffer("방가");

        sb1.append("하세요");
        sb1.append(100);

        String str1 = sb1.toString();
        System.out.println(str1);

        sb2.append("추가로").append("넣어도").append("가능하다");

        String str2 = sb2.toString();
        System.out.println(str2);

        System.out.println("삭제전 : " + sb2.toString());
        sb2.delete(2, 4);   // index 2~3의 문자 제거
        System.out.println("삭제후 : " + sb2.toString());

        System.out.println("삽입전 : " + sb2.toString());
        sb2.insert(2, "다라");
        System.out.println("삽입후 : " + sb2.toString());

        System.out.println("변경전 : " + sb2.toString());
        sb2.replace(0, 2, "반갑습니다");
        System.out.println("변경후 : " + sb2.toString());
    }
}
