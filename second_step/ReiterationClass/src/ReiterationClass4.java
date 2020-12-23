public class ReiterationClass4 {
    public static void main(String[] args) {
        Class200 c1 = new Class200();
        c1.disp();

        Class200 c2 = new Class200() {
            public void disp() {
                System.out.println("익명 중첩 클래스의 메서드");
            }
        };
        c2.disp();
    }
}

class Class200 {
    public void disp() {
        System.out.println("원본 클래스의 disp 메서드");
    }
}