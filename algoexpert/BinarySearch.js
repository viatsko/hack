function binarySearch(array, target) {
  let left = 0;
  let right = array.length - 1;

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);

    if (array[mid] > target) {
      right = mid - 1;
    } else if (array[mid] < target) {
      left = mid + 1;
    } else {
      return mid;
    }
  }

  return -1;
}

// Do not edit the line below.
exports.binarySearch = binarySearch;
