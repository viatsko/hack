const dsum = function (n) {
  return n === 0 ? 0 : dsum(Math.floor(n / 10)) + (n % 10);
};

const countLargestGroup = function (n) {
  let maxGroup = 0;
  let groups = {};

  for (let i = 1; i <= n; i++) {
    const sum = dsum(i);
    groups[sum] = -~groups[sum];
    maxGroup = Math.max(groups[sum], maxGroup);
  }

  let count = 0;
  for (const group of Object.values(groups)) {
    if (group === maxGroup) count++;
  }
  return count;
};
