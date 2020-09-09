function validMountainArray(A: number[]): boolean {
  let i = 1;
  let inc = 0;
  let dec = 0;

  while (A[i] > A[i - 1]) {
    i++;
    inc++;
  }

  while (A[i] < A[i - 1]) {
    i++;
    dec++;
  }

  if (i === A.length) {
    return inc > 0 && dec > 0;
  }

  return false;
}
