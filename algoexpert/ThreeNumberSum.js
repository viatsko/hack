function threeNumberSum(array, targetSum) {
  array.sort((a, b) => a - b);
  //array.sort();

  const res = [];

  for (let i = 0; i < array.length - 2; i++) {
    let left = i + 1;
    let right = array.length - 1;

    while (left < right) {
      const sum = array[i] + array[left] + array[right];

      if (sum === targetSum) {
        res.push([array[i], array[left], array[right]]);
        left++;
        right--;
      } else if (sum < targetSum) {
        left++;
      } else {
        right--;
      }
    }
  }

  return res;
}

// Do not edit the line below.
exports.threeNumberSum = threeNumberSum;
