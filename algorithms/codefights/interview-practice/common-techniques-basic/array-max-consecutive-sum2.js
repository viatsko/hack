function arrayMaxConsecutiveSum2(inputArray) {
  let sum = 0;
  let max = Number.MIN_SAFE_INTEGER;

  for (const num of inputArray) {
    sum += num;
    max = Math.max(sum, max);
    if (sum < 0) {
      sum = 0;
    }
  }

  return max;
}
