class Solution {
  public int candy(int[] ratings) {
    // [8, 4, 2, 1, 3, 6, 7, 9, 5]

    int[] rewards = new int[ratings.length];
    Arrays.fill(rewards, 1);

    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        rewards[i] = rewards[i - 1] + 1;
      }
    }

    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
      }
    }

    //System.out.println(Arrays.toString(rewards));

    return IntStream.of(rewards).sum();
  }
}
