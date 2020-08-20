public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        /* red = 0, green = 1, blue = 2 */
        int[] prevCosts = costs[0];

        int n = costs.length;

        for (int i = 1; i < n; i++) {
            int[] currentCosts = new int[3];

            currentCosts[0] = Math.min(prevCosts[1], prevCosts[2]) + costs[i][0];
            currentCosts[1] = Math.min(prevCosts[0], prevCosts[2]) + costs[i][1];
            currentCosts[2] = Math.min(prevCosts[0], prevCosts[1]) + costs[i][2];

            prevCosts = currentCosts;
        }

        return Math.min(Math.min(prevCosts[0], prevCosts[1]), prevCosts[2]);
    }
}
