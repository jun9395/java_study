public class Class1 {
    int defaultValue = 100;
    private int privateValue = 200;

    // Setter
    public void setPrivateValue(int privateValue) {
        this.privateValue = privateValue;
    }

    // Getter
    public int getPrivateValue() {
        return this.privateValue;
    }


//    private int privateValue2 = 300;
    // 이클립스에서는 source > setter and getter로 private 변수에 자동으로 함수를 부여할 수 있다
}
