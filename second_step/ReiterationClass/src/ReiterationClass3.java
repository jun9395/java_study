public class ReiterationClass3 {
    int a = 10;
    final int fa = 100;

    public static void main(String[] args) {
        int b = 20;

        class Inner3 {
            void innerMethod3() {
//                System.out.println(a);  // a가 final도 Inner3 내부의 변수도 아니라서 접근할 수 없다
//                b++;    // b의 호출 사용은 가능하지만, b를 조작 사용은 불가능
                System.out.println(b);
//                System.out.println(fa);
            }
        }
        Inner3 inner = new Inner3();
        inner.innerMethod3();


    }

//    Inner3 in;  // main 메서드 안에서 정의된 클래스에 접근 불가
}
