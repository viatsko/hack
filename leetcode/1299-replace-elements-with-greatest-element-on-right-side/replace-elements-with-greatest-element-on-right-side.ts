function replaceElements(arr: number[]): number[] {
  let max = -1;
  for (let i = arr.length - 1; i >= 0; i--) {
    let tmp = arr[i];
    arr[i] = max;
    max = Math.max(tmp, max);
  }

  return arr;
}
