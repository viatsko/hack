class Solution {
public:
    std::vector<int> findSmallestSetOfVertices(int n, std::vector<std::vector<int>>& edges) {
        std::set<int> starting_points;
        std::set<int>::iterator it;

        for (auto & edge : edges) {
            starting_points.insert(edge[0]);
        }

        for (auto & edge : edges) {
            starting_points.erase(edge[1]);
        }

        std::vector<int> result;
        for (it = starting_points.begin(); it != starting_points.end(); it++) {
            result.push_back(*it);
        }

        return result;
    }
};
