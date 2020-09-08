function selectionSort(array) {
  for (let i = 0; i < array.length - 1; i++) {
    let smallestIndex = i;
    let smallestElement = array[i];

    for (let j = i + 1; j < array.length; j++) {
      if (array[j] < smallestElement) {
        smallestIndex = j;
        smallestElement = array[j];
      }
    }

    [array[i], array[smallestIndex]] = [array[smallestIndex], array[i]];
  }

  return array;
}

// Do not edit the line below.
exports.selectionSort = selectionSort;
