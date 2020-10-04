9377. Combination Sum IV

比如[1,2,3] 4例子，当我们在计算dp[3]的时候，3可以拆分为1+x，而x即为x=dp[3-1]=dp[2]，3也可以拆分为2+x，此时x为x=dp[3-2]=dp[1]，
3同样可以拆为3+x，此时x为x=dp[3-3]=dp[0]，我们把所有的情况加起来就是组成3的所有情况了。

Run:
[1,2,3] target = 4
dp[0] = 1,
dp[1] = 1, 
dp[2] = 1 + 1 = 2, 
dp[3] = 1 + 1 + 2 = 4, 
dp[4] = 1 + 2 + 4 = 7 (we have no 4 in nums, so dp[4] = 1 + 2 + 4 = 7, not 1 + 1 + 2 + 4 = 8)

// we know that target is the sum of numbers in the array. Imagine we only need one more number to reach target, 
// this number can be any one in the array, right? So the # of combinations of target, comb[target] = sum(comb[target - nums[i]]), 
// where 0 <= i < nums.length, and target >= nums[i].
// In the example given, we can actually find the # of combinations of 4 with the # of combinations of 3(4 - 1), 2(4- 2) and 1(4 - 3). 
// As a result, comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = comb[3] + comb[2] + comb[1].

public int combinationSum4(int[] nums, int target) {
	if (nums.length == 0)	return 0; // important since dp[0] = 1
	int[] dp = new int[target + 1];
	dp[0] = 1;
	Arrays.sort(nums);
	// if target is much larger than num of nums, we can sort nums and break the inner for loop if j > i
	for (int i = 1; i <= target; i++) {
		for (int j = 0; j < nums.length && nums[j] <= i; j++) // notice: nums[j] <= i
			dp[i] += dp[i - nums[j]]; 
	}
	return dp[target];
}

*****Follow Up*****

What if negative numbers are allowed in the given array?
	Then adding a num to the combination is not guaranteed to be increasing, which means I can add a huge bounch of negative nums
	and add a huge bounch of positive nums to achieve a target sum. 
	eg.target=0:[-1,1],[-1,-1,1,1],[-1,-1,-1,1,1,1]...

How does it change the problem?
	We will have lots of lots of possible combinations, even infinity.

What limitation we need to add to the question to allow negative numbers?
	For example, each negative num can only be used once, etc.



' '''''''''''''''''''''''''''''''''''''''''''''''''''''''' '

40. Combination Sum II

public List<List<Integer>> combinationSum2(int[] nums, int target) {
	List<List<Integer>> res = new ArrayList<>();
	Arrays.sort(nums);
    dfs(res, new ArrayList<>(), nums, target, 0);
    return res;
}
private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int sum, int start) {
	if (sum < 0) return;
	if (sum == 0) {
		res.add(new ArrayList<>(tmp));
		return;
	}
	for (int i = start; i < nums.length; i++) {
		if (i > start && nums[i] == nums[i - 1])	continue;
		tmp.add(nums[i]);
		dfs(res, tmp, nums, sum - nums[i], i + 1);
		tmp.remove(tmp.size() - 1);
	}
}





















