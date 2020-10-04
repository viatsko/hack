121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5
max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0
In this case, no transaction is done, i.e. max profit = 0.


Solution 1: kadane algorithm

public int maxProfit(int[] prices) {
	int maxCur = 0, maxSoFar = 0;
	for (int i = 1; i > prices.length; i++) {
		maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
		maxSoFar = Math.max(maxSoFar, maxCur);
	}
	return maxSoFar;
}

Solution 2: straight forward
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int min = prices[0], res = 0;
    for (int i = 1; i < prices.length; i++)
        if (prices[i] < min)    min = prices[i];
        else    res = Math.max(res, prices[i] - min);
    return res;
}


-------------------------------------------
122. Best Time to Buy and Sell Stock II
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


public int maxProfit(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; i++)
        max += Math.max(0, prices[i] - prices[i - 1]);
    return max;
}


-------------------------------------------
123. Best Time to Buy and Sell Stock III
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

public int maxProfit(int[] prices) {
    int oneBuy = Integer.MIN_VALUE, oneBuyOneSell = 0, twoBuy = Integer.MIN_VALUE, twoBuyTwoSell = 0;
    for (int p : prices) {
        oneBuy = Math.max(oneBuy, -p);
        oneBuyOneSell = Math.max(oneBuyOneSell, oneBuy + p);
        twoBuy = Math.max(twoBuy, oneBuyOneSell - p);
        twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + p);
    }
    //return Math.max(oneBuyOneSell, twoBuyTwoSell);
    return twoBuyTwoSell;
}

The return statement can just be "return twoBuyTwoSell", since if oneBuyOneSell is the way we make max profit our twoBuyTwoSell will be set to oneBuyOneSell . 
But I still keep it to make the logic more clear.


-------------------------------------------
188. Best Time to Buy and Sell Stock IV
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.

Solution: DP
local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(0, prices[j] - prices[j - 1]), local[i][j - 1] + prices[j] - prices[j - 1]);
global[i][j] = Math.max(global[i][j - 1], local[i][j]);

Time: O(nk)

[Reference]//https://aaronice.gitbooks.io/lintcode/content/high_frequency/best_time_to_buy_and_sell_stock_iv.html

public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1)     return 0;
    if (k >= n / 2) {
        int max = 0;
        for (int i = 1; i < n; i++)
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        return max;
    }
    int[][] dp = new int[k + 1][n];
    for (int i = 1; i <= k; i++) {
        int local = 0;
        for (int j = 1; j < n; j++) {
            local = Math.max(dp[i - 1][j - 1] + Math.max(0, prices[j] - prices[j - 1]), local + prices[j] - prices[j - 1]);
            dp[i][j] = Math.max(dp[i][j - 1], local);
        }
    }
    return dp[k][n - 1];
}

public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1)     return 0;
    if (k >= n / 2) {
        int max = 0;
        for (int i = 1; i < n; i++)
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        return max;
    }
    int[][] global = new int[k + 1][n];
    int[][] local = new int[k + 1][n];
    for (int i = 1; i <= k; i++) {
        int local = 0;
        for (int j = 1; j < n; j++) {
            local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(0, prices[j] - prices[j - 1]), local[i][j - 1] + prices[j] - prices[j - 1]);
            global[i][j] = Math.max(global[i][j - 1], local[i][j]);
        }
    }
    return global[k][n - 1];
}



-------------------------------------------
309. Best Time to Buy and Sell Stock with Cooldown
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

Solution: DP
buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);   
sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

public int maxProfit(int[] prices) {
    int prev_sell = 0, sell = 0, prev_buy = Integer.MIN_VALUE, buy = prev_buy;
    for (int p : prices) {
        prev_buy = buy; // prev_buy : buy[i - 1]
        buy = Math.max(prev_buy, prev_sell - p); // prev_sell : sell[i - 2]
        prev_sell = sell; // prev_sell : sell[i - 1]
        sell = Math.max(prev_sell, prev_buy + p); // prev_buy : buy[i - 1]
    }
    return sell;
}







