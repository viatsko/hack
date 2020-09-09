function sortArrayByParity(A: number[]): number[] {
  let result: number[] = [];
  let left = 0;
  let right = A.length - 1;

  for (let i = 0; i < A.length; i++) {
    if (A[i] % 2 === 0) {
      result[left++] = A[i];
    } else {
      result[right--] = A[i];
    }
  }

  return result;
}
