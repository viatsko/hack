import java.io.*;
import java.util.Arrays;

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        in.close();

        if (n < 2) {
            return;
        }

        boolean[] prime = new boolean[n];

        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        int m = (int) (1.25506 * n / Math.log(n));

        for (int i = 2; i < m; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                out.write(i + " ");
            }
        }
        out.close();
    }
}
