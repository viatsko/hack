import java.util.*;
import java.util.stream.Collectors;

public class JavaArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<List<Integer>> arr = new ArrayList<>();

        int n = in.nextInt();

        in.nextLine();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }

        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int x = in.nextInt() - 1;

            int y = in.nextInt();

            if (x >= arr.size() || y >= arr.get(x).size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(arr.get(x).get(y));
            }
        }
    }
}
