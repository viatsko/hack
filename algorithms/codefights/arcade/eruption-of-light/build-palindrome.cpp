#include <string>

std::string buildPalindrome(std::string st) {
  for (std::string::size_type i = 0; i < st.size(); i++) {
    std::string sst = st.substr(i);
    std::string rsst = std::string(sst.rbegin(), sst.rend());
    if (sst == rsst) {
      std::string rvst = st.substr(0, i);
      std::reverse(rvst.begin(), rvst.end());
      return st + rvst;
    }
  }

  return std::string("");
}
