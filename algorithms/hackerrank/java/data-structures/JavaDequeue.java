import java.util.*;

public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();

        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            set.add(num);

            deque.add(num);

            if (deque.size() == m) {
                max = Math.max(set.size(), max);

                int current = deque.remove();

                if (!deque.contains(current)) {
                    set.remove(current);
                }
            }
        }

        System.out.println(max);
    }
}
