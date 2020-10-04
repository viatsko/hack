Least Removal to Valid Palindromic Subsequence

做最小的修改把invalid 变成valid，只能delete，但是直接remove比较占时间复杂度。


其中一个方法是求出当前string和它的reversed string的LCS，然后用当前s.length()减去LCS长度就得出最少删除/插入字符的回文了
你可以试试看，我这个方法是通用的，比如输入abca，它会输出1而不会是3，若输出3那就成了只解决删头尾情况了

LCS: [YouTube] // https://www.youtube.com/watch?v=NnD96abizww

public int minRemovalPalindrome(String s) {
	if (s == null || s.length() == 0)	return 0;
	int lcs = longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
	return s.length() - lcs;
}
private int longestCommonSubsequence(String s, String t) {
	int m = s.length(), n = t.length();
	int[][] dp = new int[m + 1][n + 1];
	for (int i = 1; i <= m; i++)
		for (int j = 1; j <= n; j++) {
			if (s.charAt(i - 1) == t.charAt(j - 1))
				dp[i][j] = dp[i - 1][j - 1] + 1;
			else	dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		}
	return dp[m][n];
}

