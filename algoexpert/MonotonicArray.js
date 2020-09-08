function isMonotonic(array) {
  if (array.length <= 1) {
    return true;
  }

  let diff;
  for (let i = 0; i < array.length - 1; i++) {
    if (array[i] === array[i + 1]) {
      continue;
    }

    if (diff === undefined) {
      if (array[i + 1] - array[i] > 0) {
        diff = 1;
      } else {
        diff = -1;
      }
    } else {
      if (diff === -1 && array[i + 1] - array[i] > 0) {
        return false;
      }
      if (diff === 1 && array[i + 1] - array[i] < 0) {
        return false;
      }
    }
  }

  return true;
}

// Do not edit the line below.
exports.isMonotonic = isMonotonic;
