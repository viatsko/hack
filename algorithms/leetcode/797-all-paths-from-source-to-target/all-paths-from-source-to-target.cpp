#include <vector>

class Solution {
public:
  void dfs(std::vector<std::vector<int>>& result, std::vector<std::vector<int>>& graph, std::vector<int> path, int position) {
    path.push_back(position);
    if (position == graph.size() - 1) {
      result.push_back(path);
    } else {
      for (const int& child : graph[position]) {
        dfs(result, graph, path, child);
      }
    }
  }

  std::vector<std::vector<int>> allPathsSourceTarget(std::vector<std::vector<int>>& graph) {
    std::vector<std::vector<int>> result;
    dfs(result, graph, std::vector<int>(), 0);
    return result;
  }
};
