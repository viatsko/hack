function sumInRange(nums, queries) {
  const sums = new Map();

  for (let i = 0, curSum = 0; i <= nums.length; i++) {
    sums.set(i, curSum);
    curSum += nums[i];
  }

  let sum = 0;
  for (const query of queries) {
    sum += sums.get(query[1] + 1) - sums.get(query[0]);
  }

  return (sum % 1000000007 + 1000000007) % 1000000007;
}
