function fourSum(nums: number[], target: number): number[][] {
  nums.sort((a, b) => a - b);

  const res: number[][] = [];

  for (let i = 0; i < nums.length; i++) {
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue;
    }

    for (let j = i + 1; j < nums.length; j++) {
      if (j > i + 1 && nums[j] === nums[j - 1]) {
        continue;
      }

      const subResults = twoSum(nums, j + 1, target - nums[i] - nums[j]);

      for (const subRes of subResults) {
        if (nums[i] + nums[j] + subRes[0] + subRes[1] === target) {
          res.push([nums[i], nums[j]].concat(subRes));
        }
      }
    }
  }

  return res;
}

function twoSum(
  nums: number[],
  startIndex: number,
  target: number
): number[][] {
  let left = startIndex;
  let right = nums.length - 1;

  const res: number[][] = [];

  while (left < right) {
    const sum = nums[left] + nums[right];
    if (sum < target || (left > startIndex && nums[left - 1] === nums[left])) {
      left++;
    } else if (
      sum > target ||
      (right < nums.length - 1 && nums[right + 1] === nums[right])
    ) {
      right--;
    } else {
      res.push([nums[left], nums[right]]);
      left++;
      right--;
    }
  }

  return res;
}
