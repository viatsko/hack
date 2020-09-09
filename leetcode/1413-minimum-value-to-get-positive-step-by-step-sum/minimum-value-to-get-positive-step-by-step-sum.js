function minStartValue(nums: number[]): number {
  let sum = 0;
  let minSum = 0;

  for (let i = 0; i < nums.length; i++) {
    sum += nums[i];
    minSum = Math.min(minSum, sum);
  }

  return 1 - minSum;
}
