function findMaxConsecutiveOnes(nums: number[]): number {
  let prevOnes = -1;
  let ones = 0;

  let res = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === 0) {
      prevOnes = ones;
      ones = 0;
    } else {
      ones++;
    }
    res = Math.max(res, prevOnes + ones + 1);
  }
  return res;
}
