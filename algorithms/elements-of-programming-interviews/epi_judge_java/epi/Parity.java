package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class Parity {
    private static int BITMASK = 0xFFFF;

    private static int countOnes(int i) {
        short answer = 0;
        while (i != 0) {
            i &= (i - 1);
            answer++;
        }
        return answer & 1;
    }

    private static int[] lookupTable = new int[BITMASK];

    private static void prefillLookupTable() {
        for (int i = 0; i < BITMASK; i++) {
            lookupTable[i] = countOnes(i);
        }
    }

    @EpiTest(testDataFile = "parity.tsv")
    public static short parity(long x) {
        // TODO - you fill in here.
        final int WORDSIZE = 16;
        return (short) (
                lookupTable[(int) (x & BITMASK)] ^
                        lookupTable[(int) (x >> WORDSIZE & BITMASK)] ^
                        lookupTable[(int) (x >> WORDSIZE * 2 & BITMASK)] ^
                        lookupTable[(int) (x >> WORDSIZE * 3 & BITMASK)]);
    }

    public static void main(String[] args) {
        prefillLookupTable();
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "Parity.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
