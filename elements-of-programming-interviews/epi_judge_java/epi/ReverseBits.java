package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class ReverseBits {
    @EpiTest(testDataFile = "reverse_bits.tsv")
    public static long reverseBits(long x) {
        for (int i = 0; i < 32; i++) {
            int j = 63 - i;

            if (((x >>> i) & 1) != ((x >>> j) & 1)) {
                x ^= (1L << i)|(1L << j);
            }
        }

        return x;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ReverseBits.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
