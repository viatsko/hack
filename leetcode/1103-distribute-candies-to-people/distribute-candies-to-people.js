/**
 * @param {number} candies
 * @param {number} num_people
 * @return {number[]}
 */
const distributeCandies = function (candies, num_people) {
  const result = new Array(num_people).fill(0);

  let i = 0;
  while (candies > 0) {
    result[i % num_people] += Math.min(candies, i + 1);
    candies -= i + 1;
    i++;
  }

  return result;
};
