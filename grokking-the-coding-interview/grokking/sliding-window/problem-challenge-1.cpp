using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>

class StringPermutation {
 public:
  static bool findPermutation(const string &str, const string &pattern) {
    unordered_map<char,int> orig;
    for (const auto &ch : pattern) {
      orig[ch]++;
    }
    unordered_map<char,int> curr(orig);
    for (const auto &ch : str) {
      if (curr.find(ch) != curr.end()) {
        curr[ch]--;
        if (curr[ch] == 0) {
          curr.erase(ch);
        }
        if (curr.size() == 0) {
          return true;
        }
      } else {
        curr = orig;
      }
    }
    return false;
  }
};
