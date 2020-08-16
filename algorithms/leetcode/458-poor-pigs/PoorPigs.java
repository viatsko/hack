public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log((double) buckets) / Math.log((double) minutesToTest / minutesToDie + 1));
    }
}
