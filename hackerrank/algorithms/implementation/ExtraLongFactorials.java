import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        BigInteger nb = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            nb = nb.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(nb.toString());
    }
}
