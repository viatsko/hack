import java.util.Scanner;
import java.util.Stack;

public class QueuesATaleOfTwoStacks {
    static class Queue<T> {
        Stack<T> in;

        Stack<T> out;

        Queue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        void enqueue(T element) {
            in.push(element);
        }

        void dequeue() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            if (!out.isEmpty()) {
                out.pop();
            }
        }

        T peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }

            return out.peek();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        Queue<Integer> queue = new Queue<>();

        for (int i = 0; i < t; i++) {
            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    queue.enqueue(scanner.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
            }
        }
    }
}
