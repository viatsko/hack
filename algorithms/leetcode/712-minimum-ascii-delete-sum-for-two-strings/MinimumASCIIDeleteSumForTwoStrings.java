class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeinteSum(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int ascii1 = 0;

        for (int i = 0; i < s1.length(); i++) {
            ascii1 += s1.charAt(i);
        }

        int ascii2 = 0;

        for (int i = 0; i < s2.length(); i++) {
            ascii2 += s2.charAt(i);
        }

        return ascii1 + ascii2 - 2 * dp[s1.length()][s2.length()];
    }
}
