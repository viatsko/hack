public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int leftBit = n & (1 << i);
            int rightBit = n & (1 << (31 - i));

            if (leftBit != 0) {
                n |= (1 << (31 - i));
            } else {
                n &= ~(1 << (31 - i));
            }
            
            if (rightBit != 0) {
                n |= (1 << i);
            } else {
                n &= ~(1 << i);
            }
        }
        
        return n;
    }
}
