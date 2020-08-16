import java.util.Stack;

public class MaxStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public void push(int x) {
        stack.push(x);

        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public int pop() {
        int popped = stack.pop();

        if (maxStack.peek() == popped) {
            maxStack.pop();
        }

        return popped;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();

        Stack<Integer> tmp = new Stack<>();

        int cur = stack.pop();

        while (!stack.isEmpty() && (cur != max)) {
            tmp.push(cur);

            cur = stack.pop();
        }

        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());

            if (maxStack.isEmpty() || stack.peek() >= maxStack.peek()) {
                maxStack.push(stack.peek());
            }
        }

        return max;
    }
}
