import java.util.Stack;

/**
 * @Author Yansufeng
 * @Date 2021/10/29 9:57 下午
 */
public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> stackForMin;

    public MinStack() {
        stack = new Stack<>();
        stackForMin = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if(!stackForMin.empty())
            if(stackForMin.peek() < x)
                return;

        stackForMin.push(x);
    }

    public void pop() {
        int top = stack.pop();

        if(stackForMin.peek() == top)
            stackForMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackForMin.peek();
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();

        m.push(0);
        m.push(1);
        m.push(0);
        System.out.println(m.min());
        m.pop();
        System.out.println(m.min());
    }
}
