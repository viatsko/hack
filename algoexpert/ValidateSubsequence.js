function isValidSubsequence(array, sequence) {
  let s = 0;

  for (let i = 0; i < array.length; i++) {
    if (array[i] === sequence[s]) {
      s++;
    }
  }

  if (s >= sequence.length) {
    return true;
  }

  return false;
}

// Do not edit the line below.
exports.isValidSubsequence = isValidSubsequence;
