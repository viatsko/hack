#include <string>
#include <vector>
using namespace std;

class Solution {
private:
    struct TrieNode {
        bool isWord;
        vector<TrieNode *> children;

        TrieNode(): isWord{false}, children(26) {};
    };
public:
    string boldWords(const vector<string>& words, const string& S) {
        TrieNode* root = new TrieNode;

        for (auto word : words) {
            TrieNode * node = root;

            for (string::size_type i = 0; i < word.size(); i++) {
                int idx = word[i] - 'a';
                if (node->children[idx] == nullptr) {
                    node->children[idx] = new TrieNode;
                }
                node = node->children[idx];
            }

            node->isWord = true;
        }

        vector<vector<int>> intervals;

        for (string::size_type i = 0; i < S.size(); i++) {
            TrieNode * node = root;
            for (string::size_type j = i; j < S.size(); j++) {
                int idx = S[j] - 'a';
                if (node->children[idx] == nullptr) {
                    break;
                }
                node = node->children[idx];
                if (node->isWord) {
                    vector<int> interval = {i, j};
                    intervals.push_back(interval);
                }
            }
        }

        /* now merging intervals */
        vector<vector<int>> merged;
        vector<int>::size_type len = intervals.size();
        for (vector<int>::size_type i = 0; i < len; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while ((i < len - 1) && (intervals[i + 1][0] - 1) <= end) {
                end = max(end, intervals[i + 1][1]);
                i++;
            }

            vector<int> interval = {start, end};
            merged.push_back(interval);
        }

        if (merged.empty()) {
            return S;
        }

        string result = "";
        vector<int>::size_type current = 0;
        vector<int> current_interval = merged[current];
        for (string::size_type i = 0; i < S.length(); i++) {
            if (i == current_interval[0]) {
                result += "<b>";
            }
            result.push_back(S[i]);
            if (i == current_interval[1]) {
                result += "</b>";
                if (current < merged.size() - 1) {
                    current_interval = merged[++current];
                } else {
                    current_interval = {-1, -1};
                }
            }
        }

        return result;
    }
};
