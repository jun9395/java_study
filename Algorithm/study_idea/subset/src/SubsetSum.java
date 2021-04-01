import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {
    // N개의 숫자들 중에서 부분집합 찾기

    static int N, totalCnt, S;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        S = sc.nextInt();   // 목표 함

        input = new int[N];
        isSelected = new boolean[N];
        Arrays.fill(isSelected, false);

        for (int i = 0; i < N; i++)
            input[i] = sc.nextInt();

        generateSubset(0);
        System.out.println("총 경우의 수 : " + totalCnt);
    }


    private static void generateSubset(int cnt) {

        if (cnt == N) {
            // 부분집합의 구성요소의 합
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) sum += input[i];
            }

            if (sum == S) {
                ++totalCnt;
                for (int i = 0; i < N; i++) {
                    System.out.print( isSelected[i] ? input[i] + "\t" : "");
//                    System.out.print("\t");
                }

                System.out.println();

            }
            return;
        }

        // 부분집합의 구성에 포함
        isSelected[cnt] = true;
        generateSubset(cnt + 1);    // 다음 원소로 넘어감
        // 부분집합의 구성에 비포함
        isSelected[cnt] = false;
        generateSubset(cnt + 1);    // 다음 원소로 넘어감
    }
}
