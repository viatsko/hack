function moveElementToEnd(array, toMove) {
  let left = 0;
  let right = array.length - 1;

  while (left < right) {
    while (array[right] === toMove) {
      right--;
    }

    if (left < right && array[left] === toMove) {
      [array[left], array[right]] = [array[right], array[left]];
      right--;
    } else {
      left++;
    }
  }

  return array;
}

// Do not edit the line below.
exports.moveElementToEnd = moveElementToEnd;
