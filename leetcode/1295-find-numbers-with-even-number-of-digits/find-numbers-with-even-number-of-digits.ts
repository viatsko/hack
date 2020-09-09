function findNumbers(nums: number[]): number {
  let res = 0;

  for (const num of nums) {
    if (Math.floor(Math.log10(num) + 1) % 2 === 0) {
      res++;
    }
  }

  return res;
}
