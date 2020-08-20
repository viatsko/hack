const myArray = [3, 4, 6, 10, 11, 15];
const alicesArray = [1, 5, 8, 12, 14, 19];

function mergeArrays(arr1, arr2) {
  const result = [];

  while (arr1.length && arr2.length) {
    if (arr1[0] < arr2[0]) {
      result.push(arr1.shift());
    } else {
      result.push(arr2.shift());
    }
  }

  if (arr1.length) {
    result.push.call(result, ...arr1);
  }

  if (arr2.length) {
    result.push.call(result, ...arr2);
  }

  return result;
}

console.log(mergeArrays(myArray, alicesArray));
// logs [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
