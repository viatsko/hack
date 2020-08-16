class Solution {
public:
    void backtrack(std::string &S, int position, std::vector<std::string> &result) {
        if (position == S.size()) {
            result.push_back(S);

            return;
        }

        backtrack(S, position + 1, result);

        if (isalpha(S[position])) {
            S[position] = isupper(S[position]) ? tolower(S[position]) : toupper(S[position]);

            backtrack(S, position + 1, result);
        }
    }

    std::vector<std::string> letterCasePermutation(std::string S) {
        std::vector<std::string> result;

        backtrack(S, 0, result);

        return result;
    }
};
