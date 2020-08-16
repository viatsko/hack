#include <set>
#include <vector>

class Solution {
public:
  bool containsDuplicate(std::vector<int>& nums) {
    std::set<int> st;

    for (auto num : nums) {
      if (st.find(num) != st.end()) {
        return true;
      }

      st.insert(num);
    }

    return false;
  }
};
