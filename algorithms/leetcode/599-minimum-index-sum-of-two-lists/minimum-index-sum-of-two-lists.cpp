class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        vector<string> result;

        int min = INT_MAX;
        unordered_map<string, unsigned int> m;

        for (int i = 0; i < list1.size(); i++) {
            m[list1[i]] = i;
        }

        for (int i = 0; i < list2.size(); i++) {
            auto it = m.find(list2[i]);
            if (it != m.end()) {
                if (m[list2[i]] + i < min) {
                    min = m[list2[i]] + i;
                    result.clear();
                    result.push_back(list2[i]);
                } else if (m[list2[i]] + i == min) {
                    result.push_back(list2[i]);
                }
            }
        }

        return result;
    }
};
