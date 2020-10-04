494. Target Sum
// https://leetcode.com/problems/target-sum/

Solution 1: subset sum + DP
Time: O(nk)

The original problem statement is equivalent to: Find a subset of nums that need to be positive and the rest of them negative such that the sum is equal to target. Let P be the positive subset and N be the negative subset
                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
So the original problem has been converted to a subset sum problem as follows:
Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2.
Note that the above formula has proved that target + sum(nums) must be even, We can use that fact to quickly identify inputs that do not have a solution <!-- subset sum: https://leetcode.com/problems/partition-equal-subset-sum/ -->

public int findTargetSumWays(int[] nums, int s) {
    int sum = 0;
    for (int n : nums)
        sum += n;
    return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) / 2);
}
public int subsetSum(int[] nums, int s) {
    int[] dp = new int[s + 1];
    dp[0] = 1;
    for (int n : nums)
        for (int i = s; i >= n; i--)
            dp[i] += dp[i - n];
    return dp[s];
}

[subset sum]
//http://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/



Solution 2: DFS + memoization
先找到第一步的所有可能，在每种第一步的可能下再试遍第二步的所有可能……以这种方式试遍所有的组合。但是如果中途发现某一个组合肯定没前途，则立刻放弃这个组合（Backtrack）。
此题和Combination sum完全不同！
combination sum是每次在数组空间内选择一个数使得最终sum = target，而此题是每次对当前位置的数选择 + 或 -，最终目标是给每个数都赋予符号并使sum = target

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
//options: + , -
//map : [[4,4 = 1],[4,2 = 1],[3,3 = 2],[3,1 = 1],[2,2 = 3],[4,-2 = 0],[3,-1 = 0],[2,0 = 1],[1,1 = 4],[4,-4 = 0],[3,-3 = 0],[2,-2 = 0],[1,-1 = 1],[0,0 = 5]]
public int findTargetSumWays(int[] nums, int S) {
    Map<String, Integer> map = new HashMap<>();
    return dfs(nums, S, 0, map);
}
private int dfs(int[] nums, int sum, int i, Map<String, Integer> map) {
    String key = i + ": " + sum;
    if (map.containsKey(key))   return map.get(key);
    if (i == nums.length)
        return sum == 0 ? 1 : 0;
    int add = dfs(nums, sum - nums[i], i + 1, map);
    int minus = dfs(nums, sum + nums[i], i + 1, map);
    map.put(key, add + minus);
    return add + minus;
}





