#include <vector>

class Solution {
public:
  std::vector<std::vector<int>> generateMatrix(int n) {
    std::vector<std::vector<int>> matrix(n);
    for(auto& submatrix : matrix) {
      submatrix.resize(n);
    }

    int il = 0;
    int ir = n - 1;

    int jt = 0;
    int jb = n - 1;

    for (int z = 0; z < n * n;) {
      for (int i = il; i < ir + 1; i++) {
        matrix[jt][i] = ++z;
      }
      jt++;

      for (int i = jt; i < jb + 1; i++) {
        matrix[i][ir] = ++z;
      }
      ir--;

      for (int i = ir; i >= il; i--) {
        matrix[jb][i] = ++z;
      }
      jb--;

      for (int i = jb; i >= jt; i--) {
        matrix[i][il] = ++z;
      }
      il++;
    }

    return matrix;
  }
};
