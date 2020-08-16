import java.math.BigDecimal;
import java.util.*;

public class JavaBigDecimal {

    public static void main(String[] args) {
        //Input
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        String[] s = new String[n + 2];

        for (int i = 0; i < n; i++) {
            s[i] = in.next();
        }

        in.close();

        // Code
        Arrays.sort(s, 0, n, Collections.reverseOrder(Comparator.comparing(BigDecimal::new)));

        // Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
