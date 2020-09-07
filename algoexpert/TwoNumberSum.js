function twoNumberSum(array, targetSum) {
  const set = new Set();

  for (let i = 0; i < array.length; i++) {
    if (set.has(targetSum - array[i])) {
      return [targetSum - array[i], array[i]];
    }

    set.add(array[i]);
  }

  return [];
}

// Do not edit the line below.
exports.twoNumberSum = twoNumberSum;
