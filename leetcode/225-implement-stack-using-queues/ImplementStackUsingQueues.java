import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Swap queues */
        private void swap() {
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(q1.size() > 1) {
                q2.add(q1.remove());
            }

            int value = q1.remove();

            swap();

            return value;
        }

        /** Get the top element. */
        public int top() {
            while(q1.size() > 1) {
                q2.add(q1.remove());
            }

            int value = q1.remove();

            swap();

            q1.add(value);

            return value;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.size() == 0 && q2.size() == 0;
        }
    }
}
