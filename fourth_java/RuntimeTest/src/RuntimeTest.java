import java.util.Vector;

public class RuntimeTest {
    public static void main(String[] args) {
        // 런타임 객체를 얻어온다
        Runtime run = Runtime.getRuntime();


        // 메모리량
        long total = run.totalMemory();
        long free = run.freeMemory();
        long used = total - free;

        System.out.println("총 메모리 : " + total);
        System.out.println("여유 메모리 : " + free);
        System.out.println("사용 메모리 : " + used);


        // 프로그램 실행
        try {
            run.exec("calc.exe");
            run.exec("notepad.exe");
            run.exec("explorer.exe http://www.naver.com");
        } catch (Exception e) {}


        // 메모리 정리
        // 프로그램 실행 중에 메모리 정리할 때
        // 객체를 생성해서 그 객체를 참조하는 참조변수가 없다고 하면 소멸 목표가 된다
        Vector v = new Vector();
        v = null;   // 소멸의 대상이 된다

        // 메모리 소멸 강제 작업
        run.gc();
        System.gc();
        // 메모리 청소는 운영체제 입장에서는 부담되는 작업이다
        // 놔둬도 램이 부족하면 알아서 정리하므로 꼭 필요할 때만 실시하자
    }
}
