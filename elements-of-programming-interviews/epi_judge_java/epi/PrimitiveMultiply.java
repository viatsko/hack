package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class PrimitiveMultiply {
    /*
        grade-school algo

        111
         11
        ---
        111
       1110
       ----

     */

    @EpiTest(testDataFile = "primitive_multiply.tsv")
    public static long multiply(long x, long y) {
        long sum = 0;
        while (y != 0) {
            if((y & 1) == 1) {
                sum = add(sum, x);
            }

            y >>= 1;
            x <<= 1;
        }

        return sum;
    }

    private static long add(long x, long y) {
        while (y != 0) {
            long carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }

        return x;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "PrimitiveMultiply.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
