package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {
  public enum Color {
    RED,
    WHITE,
    BLUE
  }

//  public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
//    Color pivot = A.get(pivotIndex);
//
//    int low = 0;
//    for (int i = 0; i < A.size(); i++) {
//      if (A.get(i).ordinal() < pivot.ordinal()) {
//        Collections.swap(A, i, low);
//        low++;
//      }
//    }
//
//    int high = A.size() - 1;
//    for (int i = high; i >= 0; i--) {
//      if (A.get(i).ordinal() > pivot.ordinal()) {
//        Collections.swap(A, i, high);
//        high--;
//      }
//    }
//  }

  public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
    Color pivot = A.get(pivotIndex);

    int low = 0;
    int equal = 0;
    int high = A.size();

    int pivotValue = pivot.ordinal();

    while (equal < high) {
      int currentValue = A.get(equal).ordinal();

      if (currentValue < pivotValue) {
        Collections.swap(A, low++, equal++);
      } else if (currentValue == pivotValue) {
        equal++;
      } else {
        Collections.swap(A, equal, --high);
      }
    }
  }

  @EpiTest(testDataFile = "dutch_national_flag.tsv")
  public static void dutchFlagPartitionWrapper(
      TimedExecutor executor, List<Integer> A, int pivotIdx) throws Exception {
    List<Color> colors = new ArrayList<>();
    int[] count = new int[3];

    Color[] C = Color.values();
    for (int i = 0; i < A.size(); i++) {
      count[A.get(i)]++;
      colors.add(C[A.get(i)]);
    }

    Color pivot = colors.get(pivotIdx);
    executor.run(() -> dutchFlagPartition(pivotIdx, colors));

    int i = 0;
    while (i < colors.size() && colors.get(i).ordinal() < pivot.ordinal()) {
      count[colors.get(i).ordinal()]--;
      ++i;
    }

    while (i < colors.size() && colors.get(i).ordinal() == pivot.ordinal()) {
      count[colors.get(i).ordinal()]--;
      ++i;
    }

    while (i < colors.size() && colors.get(i).ordinal() > pivot.ordinal()) {
      count[colors.get(i).ordinal()]--;
      ++i;
    }

    if (i != colors.size()) {
      throw new TestFailure("Not partitioned after " + Integer.toString(i) + "th element");
    } else if (count[0] != 0 || count[1] != 0 || count[2] != 0) {
      throw new TestFailure("Some elements are missing from original array");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest.runFromAnnotations(
                args, "DutchNationalFlag.java", new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
