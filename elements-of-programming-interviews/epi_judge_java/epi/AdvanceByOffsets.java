package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;

public class AdvanceByOffsets {
  @EpiTest(testDataFile = "advance_by_offsets.tsv")
  public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
    int maxSoFar = 0;
    int lastIndex = maxAdvanceSteps.size() - 1;
    for (int i = 0; i <= maxSoFar && i < lastIndex; i++) {
      maxSoFar = Math.max(maxSoFar, i + maxAdvanceSteps.get(i));
    }
    return maxSoFar >= lastIndex;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest.runFromAnnotations(
                args, "AdvanceByOffsets.java", new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
