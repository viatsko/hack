class Solution {
public:
    vector<int> findSubstring(const string &str, vector<string>& words) {
        int wordLength = words[0].size();

        unordered_map<string, int> mp;
        for (string word : words) {
          mp[word]++;
        }

        vector<int> resultIndices;

        int k = words.size();
        int n = str.length() - wordLength * (words.size() - 1);
        for (int i = 0; i < n; i++) {
          int matched = 0;
          unordered_map<string,int> mp2 = mp;
          //cout << "========" << i << endl;
          for (int windowEnd = i; windowEnd < str.length(); windowEnd += wordLength) {
            string rightWord = str.substr(windowEnd, wordLength);
            //cout << rightWord << endl;
            if (mp2.find(rightWord) == mp2.end()) {
              break;
            }

            mp2[rightWord]--;

            if(mp2[rightWord] < 0) {
              break;
            }

            matched++;

            if (matched == words.size()) {
              resultIndices.push_back(i);
              break;
            }
          }
        }

        return resultIndices;
    }
};
