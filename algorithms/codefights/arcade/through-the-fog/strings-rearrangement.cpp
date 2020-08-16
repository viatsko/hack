#include <iostream>
#include <string>
#include <vector>

bool areOneAway(std::string str1, std::string str2) {
  unsigned int count = 0;
  for (std::string::size_type i = 0; i < str1.size(); i++) {
    if (str1[i] != str2[i]) {
      if (++count > 1) {
        return false;
      }
    }
  }

  return count == 1;
}

bool backtrack(std::vector<std::string>& inputArray, std::vector<bool> visited, int position) {
  if(std::find(visited.begin(), visited.end(), false) == visited.end()) {
    return true;
  }

  for (std::vector<std::string>::size_type i = 0; i < inputArray.size(); i++) {
    if (visited[i]) {
      continue;
    }

    if (areOneAway(inputArray[i], inputArray[position])) {
      visited[i] = true;

      if (backtrack(inputArray, visited, i)) {
        return true;
      }

      visited[i] = false;
    }
  }

  return false;
}

bool stringsRearrangement(std::vector<std::string> inputArray) {
  for (std::vector<std::string>::size_type i = 0; i < inputArray.size(); i++) {
    std::vector<bool> visited(inputArray.size(), false);

    if (backtrack(inputArray, visited, i)) {
      return true;
    }
  }

  return false;
}
