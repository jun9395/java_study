import java.util.LinkedList;

public class Solution {
    // enQueue(item) 큐에 아이템 삽입
    // deQueue() 큐에서 아이템 추출
    // createQueue() 공백 상태인 큐 생성
    // isEmpty() 큐가 공백인지 확인
    // isFull() 큐가 포화인지 확인
    // Qpeek() 큐의 앞쪽에 뭐가 있는지 복사

    // 자바에서는 LinkedList 클래스를 구현체로 사용
    // java.util.Queue
    // offer() : enQueue
    // poll() : deQueue
    // isEmpty() : isEmpty
    // size() : array의 length

    // Queue a = new LinkedList;
    // 라고 하면 Queue는 LinkedList를 상속해서 더 작은 범위이므로
    // a.함수 에서 함수는 Queue에 해당하는 함수만 나온다.


    public static void main(String[] args) {

        // ArrayList를 사용해서 순서대로 넣고 순서대로 빼는 방법도 있다
        LinkedList<String> queue = new LinkedList<>();

        queue.offer("첫 번째");
        queue.offer("두 번째");
        System.out.println(queue.poll());

        queue.offerFirst("앞에 넣는다");     // 이건 deque의 함수다
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
