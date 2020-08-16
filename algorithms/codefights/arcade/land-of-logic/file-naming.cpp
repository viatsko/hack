#include <map>
#include <set>
#include <sstream>
#include <string>
#include <vector>

std::vector<std::string> fileNaming(std::vector<std::string> names) {
  std::vector<std::string> result;

  std::set<std::string> st;

  for (std::string const& name : names) {
    if (st.find(name) == st.end()) {
      st.insert(name);
      result.push_back(name);
    } else {
      // Guaranteed constraint is length <= 15
      for (std::size_t i = 1; i < 16; i++) {
        std::stringstream ss;
        ss << name << '(' << i << ')';

        std::string str = ss.str();

        if (st.find(str) == st.end()) {
          st.insert(str);
          result.push_back(str);
          break;
        }
      }
    }
  }

  return result;
}
