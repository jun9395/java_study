import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class StringArrayToIntArray {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = {"12", "31", "55", "25"};
        // arr1은 정렬되지 않은 상태이다
        int[] arr1 = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        // arr2는 정렬된 상태이다
        int[] arr2 = Arrays.stream(str).sorted().mapToInt(Integer::parseInt).toArray();
        try {
            for (int num1 : arr1) bw.write(num1 + " ");
            bw.newLine();
            bw.flush();
            for (int num2 : arr2) bw.write(num2 + " ");
            bw.newLine();
            bw.flush();
        } catch (Exception e) {}
        // 대신 이 작업은 직접 int a = Integer.parseInt(str[0]), ... 할 때보다 2배 가량 느리다
    }
}
