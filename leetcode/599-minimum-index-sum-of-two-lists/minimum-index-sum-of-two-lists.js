/**
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
const findRestaurant = function (list1, list2) {
  const map1 = {};

  for (let i = 0; i < list1.length; i++) {
    map1[list1[i]] = i;
  }

  let minIdx = Number.MAX_SAFE_INTEGER;
  let result = [];

  for (let i = 0; i < list2.length; i++) {
    if (map1.hasOwnProperty(list2[i])) {
      const sumIdx = map1[list2[i]] + i;

      if (sumIdx < minIdx) {
        result = [list2[i]];
        minIdx = sumIdx;
      } else if (sumIdx === minIdx) {
        result.push(list2[i]);
      }
    }
  }

  return result;
};
