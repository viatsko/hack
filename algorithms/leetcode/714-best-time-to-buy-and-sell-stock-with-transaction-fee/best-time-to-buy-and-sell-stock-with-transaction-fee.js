const maxProfit = (prices, fee) => {
    let sell = 0;
    let buy = -prices[0];
    let max = 0;

    for (let i = 1; i < prices.length; i++) {
        sell = Math.max(sell, buy + prices[i] - fee);
        buy = Math.max(buy, sell - prices[i]);
        max = Math.max(max, sell);
    }

    return max;
};
