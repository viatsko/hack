public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i, n = bits.length;
        for (i = 0; i < n - 1; i += bits[i] + 1);
        return i == n - 1;
    }
}
