import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class QueueAnswer {
    public static void main(String[] args) {
        Queue<int[]> queue = new LinkedList<>();
        int N = 20;
        int person = 1;

        queue.offer(new int[] {person, 1});

        while (N > 0 && !queue.isEmpty()) {
            int[] p = queue.poll();
            int availableCnt = (N >= p[1]) ? p[1] : N;
            N -= availableCnt;

            if (N == 0)     // 마지막 마이쮸를 가져가는 경우
                System.out.println("마지막 마이쮸를 가져간 : " + p[0] +
                        ", 가져간 개수: " + availableCnt);
            else {
                System.out.println(p[0] + "번이 " + availableCnt +
                        "개의 마이쮸를 가져감");
                ++p[1];
                queue.offer(p);     // 다시 줄서기
                queue.offer(new int[] {++person, 1});
            }
        }
    }
}
