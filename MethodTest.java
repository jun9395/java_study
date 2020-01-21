/**
 * Name : Son, Junhee
 * Phone :
 * This project :
 */
public class MethodTest {
        public static void main(String[] args) {
            MethodClass c1 = new MethodClass();
            // class가 갖고 있는 것(멤버)들을 사용하려면 객체를 생성해야(메모리를 할당해야) 한다
            c1.method1();
            c1.add(100, 200 );
            c1.add(100, 350, 1000);

            int man = c1.resultAdd(150, 300 );
            System.out.println("man의 값: " + man);
        }
}
