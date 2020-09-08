function longestPeak(array) {
  let result = 0;
  for (let i = 0; i < array.length; i++) {
    const len = findNextPeak(array, i);
    result = Math.max(result, len);
  }
  return result;
}

function findNextPeak(array, startIndex) {
  if (startIndex >= array.length - 2) {
    return 0;
  }

  let validInc = false;
  let validDec = false;

  let i = startIndex + 1;
  while (array[i - 1] < array[i]) {
    validInc = true;
    i++;
  }
  while (array[i - 1] > array[i]) {
    validDec = true;
    i++;
  }

  return validInc && validDec ? i - startIndex : 0;
}

// Do not edit the line below.
exports.longestPeak = longestPeak;
