package me.viatsko.hackercup.tourist;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.run();
    }

    private void run() {
        System.setIn(getClass().getClassLoader().getResourceAsStream("input.txt"));

        FastReader s = new FastReader();

        int T = s.nextInt();

        for (int t = 1; t <= T; t++) {
            int K = s.nextInt(); // number of attractions
            int N = s.nextInt(); // per tour
            long V = s.nextLong(); // tours

            // we use arraylist for sorting
            List<String> attractions = new ArrayList<>();
            for (int k = 0; k < K; k++) {
                attractions.add(s.next());
            }

            // if N > K he can see everything already at once
            if (N >= K) {
                String result = StringUtils.join(attractions, " ");
                System.out.println("Case #" + t + ": " + result);
            } else {
                long position = (V - 1) * N;

                boolean[] seen = new boolean[50];

                while (N-- > 0) {
                    seen[(int)(position % K)] = true;
                    position++;
                }

                StringJoiner sj = new StringJoiner(" ");

                for (int i = 0; i < seen.length; i++) {
                    if (seen[i]) {
                        sj.add(attractions.get(i));
                    }
                }

                System.out.println("Case #" + t + ": " + sj.toString());
            }
        }
    }
}
