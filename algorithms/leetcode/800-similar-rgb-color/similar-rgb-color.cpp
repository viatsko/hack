#include <string>

class Solution {
public:
    std::string similarRGB(std::string color) {
      std::string result = "#000000";

      for (int i = 1; i < 7; i += 2) {
        int value = std::stoi(color.substr(i,2), nullptr, 16);

        int index = (value + 8) / 17;

        result[i] = result[i + 1] = (index > 9 ? index - 10 + 'a' : index + '0');
      }

      return result;
    }
};
