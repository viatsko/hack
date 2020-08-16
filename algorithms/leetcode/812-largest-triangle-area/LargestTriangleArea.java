class Solution {
  public double largestTriangleArea(int[][] points) {
    double result = 0;

    for (int[] i : points) {
      for (int[] j : points) {
        for (int[] p : points) {
          result = Math.max(result, 0.5 * ((i[0] - p[0]) * (j[1] - p[1]) - (j[0] - p[0]) * (i[1] - p[1])));
        }
      }
    }

    return result;
  }
}
