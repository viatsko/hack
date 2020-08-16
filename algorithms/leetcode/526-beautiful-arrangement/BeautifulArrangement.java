public class BeautifulArrangement {
    int result = 0;

    private void backtrack(int n, int current, boolean[] visited) {
        if (current > n) {
            result++;

            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % current == 0 || current % i == 0)) {
                visited[i] = true;

                backtrack(n, current + 1, visited);

                visited[i] = false;
            }
        }
    }

    public int countArrangement(int n) {
        if (n == 0) {
            return 0;
        }

        backtrack(n, 1, new boolean[n + 1]);

        return result;
    }
}
