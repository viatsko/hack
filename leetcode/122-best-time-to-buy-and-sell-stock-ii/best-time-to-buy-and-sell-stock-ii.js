const maxProfit = prices => {
    if (prices.length < 2) {
        return 0;
    }

    let profit = 0;
    let min = prices[0];
    let cur_profit = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] < prices[i - 1]) {
            min = prices[i];
            profit += cur_profit;
            cur_profit = 0;
        }

        min = Math.min(prices[i], min);
        cur_profit = Math.max(cur_profit, prices[i] - min);
    }

    profit += cur_profit;

    return profit;
};
