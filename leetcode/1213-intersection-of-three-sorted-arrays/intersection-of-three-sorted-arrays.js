/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @param {number[]} arr3
 * @return {number[]}
 */
var arraysIntersection = function(arr1, arr2, arr3) {
  const result = [];

  let it1 = 0;
  let it2 = 0;
  let it3 = 0;

  while (
    it1 < arr1.length &&
    it2 < arr2.length &&
    it3 < arr3.length
    ) {
    const maxOfThree = Math.max(arr1[it1], arr2[it2], arr3[it3]);

    while(arr1[it1] < maxOfThree) {
      it1++;
    }

    while(arr2[it2] < maxOfThree) {
      it2++;
    }

    while(arr3[it3] < maxOfThree) {
      it3++;
    }

    if (arr1[it1] === arr2[it2] && arr2[it2] === arr3[it3]) {
      result.push(maxOfThree);
    }

    if (arr1[it1] === maxOfThree) it1++;
    if (arr2[it2] === maxOfThree) it2++;
    if (arr3[it3] === maxOfThree) it3++;
  }

  return result;
};
