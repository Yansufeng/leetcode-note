//import java.util.LinkedList;
//import java.util.Optional;
//import java.util.Queue;
import java.util.Stack;

/**
 * @Author Yansufeng
 * @Date 2021/10/29 8:41 下午
 */
public class CQueue {
//    private Queue<Integer> queue;

    private final Stack<Integer> stack;
    private final Stack<Integer> stackReverse;

    public CQueue() {
//        queue = new LinkedList<>();

        stack = new Stack<>();
        stackReverse = new Stack<>();
    }

    public void appendTail(int value) {
//        queue.offer(value);

        stack.push(value);
    }

    public int deleteHead() {
//        Optional<Integer> headOfQueue = Optional.ofNullable(queue.poll());
//
//        return headOfQueue.orElse(-1);
        if(stackReverse.empty())
            reverseStack();

        return stackReverse.empty() ? -1 : stackReverse.pop();
    }

    private void reverseStack() {
        while(!stack.empty()) {
            stackReverse.push(stack.pop());
        }
    }

    public static void main(String[] args) {
        CQueue cq = new CQueue();

        cq.appendTail(3);
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
    }
}
