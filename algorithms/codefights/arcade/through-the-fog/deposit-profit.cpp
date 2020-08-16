int depositProfit(int deposit, int rate, int threshold) {
    int result = 0;
    
    double increase = (double) rate / 100 + 1;
    double thresholdd = (double) threshold;
        
    for (double balance = (double)deposit;balance *= increase;) {
        result++;
        
        if (balance >= thresholdd) {
            break;
        }
    }
    
    return result;
}
