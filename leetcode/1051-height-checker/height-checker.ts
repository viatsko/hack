function heightChecker(heights: number[]): number {
  const sorted = [...heights];
  sorted.sort((a, b) => a - b);

  let res = 0;
  for (let i = 0; i < heights.length; i++) {
    if (sorted[i] !== heights[i]) {
      res++;
    }
  }
  return res;
}
