class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        int total = 0;
        int result = 0;

        std::sort(satisfaction.begin(), satisfaction.end(), std::greater<int>());

        for (auto & dish : satisfaction) {
            if (dish > -total) {
                total += dish;
                result += total;
            }
        }

        return result;
    }
};
