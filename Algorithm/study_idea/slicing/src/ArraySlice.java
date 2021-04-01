import java.util.Arrays;

public class ArraySlice {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};

        System.out.println("array : " + Arrays.toString(array));

        System.out.println("subarray by 3 : " + Arrays.toString(Arrays.copyOf(array, 3)));
        System.out.println("subarray from 2 to 4 : " + Arrays.toString(Arrays.copyOfRange(array, 2, 4)));

        System.out.println("array : " + Arrays.toString(array));
    }
}
