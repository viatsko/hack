class Solution {
  class Entry {
      int i;
      int j;
      int val;

      public Entry(int i, int j, int val) {
          this.i = i;
          this.j = j;
          this.val = val;
      }
  }

  private List<Entry> matrixToList(int[][] A) {
      List<Entry> list = new LinkedList<>();

      for (int i = 0; i < A.length; i++) {
          for (int j = 0; j < A[0].length; j++) {
              if (A[i][j] == 0) {
                  continue;
              }

              list.add(new Entry(i, j, A[i][j]));
          }
      }

      return list;
  }

  public int[][] multiply(int[][] A, int[][] B) {
      int MA = A.length;
      int NA = A[0].length;
      int NB = B[0].length;
      int[][] result = new int[MA][NB];

      List<Entry> listA = matrixToList(A);
      List<Entry> listB = matrixToList(B);

      for (Entry entryA : listA) {
          for (Entry entryB : listB) {
              if (entryA.j == entryB.i) {
                  result[entryA.i][entryB.j] += entryA.val * entryB.val;
              }
          }
      }

      return result;
  }
}
