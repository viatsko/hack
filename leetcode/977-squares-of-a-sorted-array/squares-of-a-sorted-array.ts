function sortedSquares(A: number[]): number[] {
  return A.map((num) => num * num).sort((a, b) => a - b);
}
