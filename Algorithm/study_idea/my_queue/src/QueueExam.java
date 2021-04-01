import java.util.LinkedList;
import java.util.Queue;

public class QueueExam {
    public static void main(String[] args) {
        int N = 30;
        Queue<Integer> queue = new LinkedList<>();

        int sum = 0, count = 1;
        queue.offer(1);
        int people;
        while (!queue.isEmpty() && sum < N) {
            people = queue.poll();
            sum += count++;
            queue.offer(people + 1);
            queue.offer(people);
        }

//        System.out.println(people);
    }
}
