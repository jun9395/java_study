import java.util.Stack;

public class StackSolution {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>();

        stack.push("이동욱");
        stack.push("이동해");
        stack.push("이동만");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
//            System.out.println(stack.peek());   // 맨 위에 뭐가 있는지 확인만 하는것
        }

        // 더 이상 뺄 게 없을 때 pop, peek 하면 EmptyStackException 발생
    }
}
