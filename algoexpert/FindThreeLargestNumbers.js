function findThreeLargestNumbers(array) {
  const largest = [
    Number.MIN_SAFE_INTEGER,
    Number.MIN_SAFE_INTEGER,
    Number.MIN_SAFE_INTEGER,
  ];
  for (const num of array) {
    updateLargestArray(largest, num);
  }

  return largest;
}

function updateLargestArray(largest, num) {
  for (let i = largest.length - 1; i >= 0; i--) {
    if (num > largest[i]) {
      shiftArray(largest, i + 1);
      largest[i] = num;
      break;
    }
  }
}

function shiftArray(array, toIndex) {
  for (let i = 0; i < toIndex; i++) {
    array[i] = array[i + 1];
  }
}

// Do not edit the line below.
exports.findThreeLargestNumbers = findThreeLargestNumbers;
