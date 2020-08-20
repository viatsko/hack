public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;

        for (int i = 0; i < timeSeries.length; i++) {
            int start = timeSeries[i];
            int end = start + duration;

            while(i < (timeSeries.length - 1) && end >= timeSeries[i + 1]) {
                end = Math.max(timeSeries[i + 1] + duration, end);
                i++;
            }

            result += end - start;
        }

        return result;
    }
}
