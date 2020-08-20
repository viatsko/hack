class Solution {
public:
    vector<int> anagramMappings(vector<int>& A, vector<int>& B) {
        vector<int> result;
        unordered_map<int, vector<int>> bmap;

        for(vector<int>::size_type i = 0; i != B.size(); i++) {
            auto got = bmap.find(B[i]);

            if (got == bmap.end()) {
                vector<int> v = { i };

                bmap.insert(make_pair(B[i], v));
            } else {
                got->second.push_back(i);
            }
        }

        for(vector<int>::size_type i = 0; i != A.size(); i++) {
            auto got = bmap.find(A[i]);

            if (got == bmap.end()) {
                // error
            } else {
                result.push_back(got->second.back());
                got->second.pop_back();
            }
        }

        return result;
    }
};
