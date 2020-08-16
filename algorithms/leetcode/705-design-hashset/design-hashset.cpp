#include <vector>
using namespace std;

class MyHashSet {
private:
    size_t TABLE_SIZE = 93;
    vector<vector<int>> inner_set;

    size_t hash(int key) {
        return key % TABLE_SIZE;
    }
public:
    /** Initialize your data structure here. */
    MyHashSet() : inner_set{TABLE_SIZE} {

    }

    void add(int key) {
        vector<int>& bucket = inner_set[hash(key)];

        auto position = std::find(bucket.begin(), bucket.end(), key);

        if (position == bucket.end()) {
            bucket.push_back(key);
        }
    }

    void remove(int key) {
        vector<int>& bucket = inner_set[hash(key)];

        auto position = std::find(bucket.begin(), bucket.end(), key);

        if (position != bucket.end()) {
            bucket.erase(position);
        }
    }

    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        vector<int>& bucket = inner_set[hash(key)];

        auto position = std::find(bucket.begin(), bucket.end(), key);

        if (position != bucket.end()) {
            return true;
        }

        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * bool param_3 = obj.contains(key);
 */
