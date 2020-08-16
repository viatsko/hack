#include <map>
#include <string>
#include <unordered_map>

std::string reflectString(std::string inputString) {
  std::unordered_map<char, char> mp;

  char left = 'a';
  char right= 'z';

  while (left <= right) {
    mp[left] = right;
    mp[right] = left;

    left++;
    right--;
  }

  for (std::string::size_type i = 0; i < inputString.size(); i++) {
    inputString[i] = mp[inputString[i]];
  }

  return inputString;
}
