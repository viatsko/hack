class Solution {
  public double average(int[] salary) {
    int total = 0;
    int div = salary.length - 2;

    int min = Integer.MAX_VALUE;
    int max = -1;
    for (int i = 0; i < salary.length; i++) {
      total += salary[i];
      min = Math.min(salary[i], min);
      max = Math.max(salary[i], max);
    }

    total -= min;
    total -= max;

    return (double) total / div;
  }
}
