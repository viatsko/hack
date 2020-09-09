function thirdMax(nums: number[]): number {
  const max: number[] = Array(3).fill(Number.MIN_SAFE_INTEGER);

  for (let i = 0; i < nums.length; i++) {
    for (let j = 0; j < max.length; j++) {
      if (nums[i] === max[j]) {
        break;
      }
      if (nums[i] > max[j]) {
        shift(max, j);
        max[j] = nums[i];
        break;
      }
    }
  }

  const res = max.filter((el) => el !== Number.MIN_SAFE_INTEGER);
  return res[2] !== undefined ? res[2] : res[0];
}

function shift(max: number[], pos: number) {
  for (let i = max.length - 1; i >= pos; i--) {
    max[i] = max[i - 1];
  }
  console.log(max);
}
