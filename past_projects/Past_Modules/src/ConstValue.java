public class ConstValue {
    public static void main(String[] args){
        System.out.printf("정수: %d\n", 101);
        System.out.printf("정수: %d %d\n", 202, 300);
        System.out.printf("%d - %d\n", -214748, 214648); // 뒤에다 L을 붙이면 8바이트 범위까지 표현가능이라고 함
        System.out.printf("%c\n", 'a');
        System.out.printf("%s\n", "이것이 자바다 실전편");
        System.out.printf("%s", "이것이 자바자 응용편\n");
        System.out.printf("%.2f\n", 3.14159205);
    }
}
