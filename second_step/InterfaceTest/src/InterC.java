// 인터페이스는 인터페이스를 상속받을 수 있다
// 클래스는 인터페이스를 상속받을 수 없다

public interface InterC extends InterA {
    int c = 30;

    public void methodC();
}
