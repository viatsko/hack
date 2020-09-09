/**
 Do not return anything, modify nums in-place instead.
 */
function moveZeroes(nums: number[]): void {
  let zeros = 0;

  let i;
  for (i = 0; i < nums.length - zeros; i++) {
    while (nums[i + zeros] === 0) {
      zeros++;
    }
    nums[i] = nums[i + zeros] || 0;
  }

  for (; i < nums.length; i++) {
    nums[i] = 0;
  }
}
