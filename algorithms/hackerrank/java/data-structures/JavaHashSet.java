import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {
            set.add(in.next() + in.next());
            System.out.println(set.size());
        }
    }
}
