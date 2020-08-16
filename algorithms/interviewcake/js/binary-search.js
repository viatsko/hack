const input = [1, 2, 3, 4, 5, 6, 7, 8];

function binarySearch(input, target) {
  let start = 0;
  let end = input.length;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);

    if (input[mid] === target) {
      return target;
    }

    if (input[mid] > target) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }

  return -1;
}

console.log(binarySearch(input, 1) === 1);
console.log(binarySearch(input, 2) === 2);
console.log(binarySearch(input, 3) === 3);
console.log(binarySearch(input, 4) === 4);
console.log(binarySearch(input, 5) === 5);
console.log(binarySearch(input, 6) === 6);
console.log(binarySearch(input, 7) === 7);
console.log(binarySearch(input, 8) === 8);
