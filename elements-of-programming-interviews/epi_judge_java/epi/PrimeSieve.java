package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrimeSieve {
  @EpiTest(testDataFile = "prime_sieve.tsv")
  // Given n, return all primes up to and including n.
  public static List<Integer> generatePrimes(int n) {
    List<Integer> result = new LinkedList<>();

    boolean[] primes = new boolean[n + 1];

    Arrays.fill(primes, true);

    for (int i = 2; i * i <= n; i++) {
      if (primes[i]) {
        for (int j = i * i; j <= n; j += i) {
          primes[j] = false;
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (primes[i]) {
        result.add(i);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest.runFromAnnotations(
                args, "PrimeSieve.java", new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
