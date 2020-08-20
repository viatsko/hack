
const wordBreak = (s, wordDict) => {
    const wordSet = new Set(wordDict);
    
    const dp = [true];
    
    for (let i = 1; i <= s.length; i++) {
        for (let j = 0; j < i; j++) {
            if (dp[j] && wordSet.has(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
    
    return !!dp[s.length];
}
