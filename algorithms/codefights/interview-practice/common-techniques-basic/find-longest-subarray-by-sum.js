function findLongestSubarrayBySum(s, arr) {
  const map = new Map();

  map.set(0, -1);

  let sum = 0;
  let len = 0;
  let end = 0;

  for (let i = 0; i < arr.length; i++) {
    sum += arr[i];

    if (!map.has(sum)) {
      map.set(sum, i);
    }

    if (map.has(sum - s) && len < i - map.get(sum - s)) {
      len = i - map.get(sum - s);
      end = i;
    }
  }

  const begin = end - len + 1;

  if (begin > end) {
    return [-1];
  } else {
    return [begin + 1, end + 1];
  }
}
